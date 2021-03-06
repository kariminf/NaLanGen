package kariminf.nalangen.nlg.simplenlg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import kariminf.nalangen.nlg.UnivRealizer;
import kariminf.nalangen.nlg.simplenlg.EngRealizer;
import kariminf.sentrep.UnivMap;
import kariminf.sentrep.ston.Ston2UnivMap;
import kariminf.sentrep.types.*;
import kariminf.sentrep.types.Relation.Relative;


public class EnRealizerTest {

	
	private static void thatTest(){
		
		UnivRealizer realizer = new EngRealizer();
		
		//Roles
		realizer.beginNounPhrase("mother", "mother");
		realizer.addNPSpecifs("", Determiner.YES, "PL");
		realizer.beginNounPhrase("food", "food");
		realizer.addNPSpecifs("", Determiner.YES, "1");
		realizer.beginRelative(Relative.OBJECT, "");
		ArrayList<String> compRefs = new ArrayList<String>();
		compRefs.add("m_ate");
		realizer.addConjunctions(compRefs);
		realizer.endRelative();
		
		realizer.beginNounPhrase("+goodfood", "food");
		ArrayList<String> adv1= new ArrayList<String>();
		adv1.add("extremely");
		realizer.addAdjective("good", adv1);
		
		//Actions
		realizer.beginSentPhrase("m_ate", "eat");
		realizer.addVerbSpecif(VerbTense.PAST, Modality.NONE, false, false, false);
		realizer.beginSubject();
		ArrayList<String> subjRefs = new ArrayList<String>();
		subjRefs.add("mother");
		realizer.addConjunctions(subjRefs);
		realizer.endSubject();
		realizer.endSentPhrase();
		
		realizer.beginSentPhrase("was", "be");
		realizer.addVerbSpecif(VerbTense.PAST, Modality.NONE, false, false, false);
		realizer.beginSubject();
		ArrayList<String> subjRefs2 = new ArrayList<String>();
		subjRefs2.add("food");
		realizer.addConjunctions(subjRefs2);
		realizer.endSubject();
		realizer.beginObject();
		ArrayList<String>  objRefs = new ArrayList<String>();
		objRefs.add("+goodfood");
		realizer.addConjunctions(objRefs);
		realizer.endObject();
		realizer.endSentPhrase();
		
		realizer.beginSentence(SentMood.AFFIRMATIVE);
		ArrayList<String>  sentRefs = new ArrayList<String>();
		sentRefs.add("was");
		realizer.addConjunctions(sentRefs);
		realizer.endSentence();
			
		System.out.println(realizer.getText());
		
	}
	
	private static void simpleTest(){
		UnivRealizer realizer = new EngRealizer();
		//realizer.showDebugMsg(true);
		//Roles
		realizer.beginNounPhrase("mother", "mother");
		realizer.addNPSpecifs("", Determiner.YES, "PL");
		
		realizer.beginNounPhrase("food", "food");
		
		//Actions
		
		realizer.beginSentPhrase("ate", "eat");
		realizer.addVerbSpecif(VerbTense.PRESENT, Modality.NONE, false, false, false);
		
		realizer.beginSubject();
		ArrayList<String> subjRefs2 = new ArrayList<String>();
		subjRefs2.add("mother");
		realizer.addConjunctions(subjRefs2);
		realizer.endSubject();
		
		realizer.beginObject();
		ArrayList<String>  objRefs = new ArrayList<String>();
		objRefs.add("food");
		realizer.addConjunctions(objRefs);
		realizer.endObject();
		
		realizer.endSentPhrase();
		//realizer.linkComplimentizers();
		
		realizer.beginSentence(SentMood.AFFIRMATIVE);
		ArrayList<String>  sentRefs = new ArrayList<String>();
		sentRefs.add("ate");
		realizer.addConjunctions(sentRefs);
		realizer.endSentence();
		
		System.out.println(realizer.getText());
	}
	
	private static void compTest(){
		UnivRealizer realizer = new EngRealizer();
		
		//Roles
		realizer.beginNounPhrase("karim", "karim");
		
		realizer.beginNounPhrase("bother", "his brother");
		
		//Actions
		
		realizer.beginSentPhrase("is", "be");
		realizer.addVerbSpecif(VerbTense.PRESENT, Modality.NONE, false, false, false);
		
		realizer.beginSubject();
		ArrayList<String> subjRefs2 = new ArrayList<String>();
		subjRefs2.add("karim");
		realizer.addConjunctions(subjRefs2);
		realizer.endSubject();
		
		/*realizer.beginObject();
		HashSet<String>  objRefs = new HashSet<String>();
		objRefs.add("food");
		realizer.addConjunctions(objRefs);
		realizer.endObject();*/
		
		realizer.endSentPhrase();
		
		
		//realizer.linkComplimentizers();
		
		realizer.beginSentence(SentMood.AFFIRMATIVE);
		ArrayList<String>  sentRefs = new ArrayList<String>();
		sentRefs.add("ate");
		realizer.addConjunctions(sentRefs);
		realizer.endSentence();
		
		System.out.println(realizer.getText());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		simpleTest();
		thatTest();

	}

}
