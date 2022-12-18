package unit;
import java.util.Queue;
import framework.Token;
import framework.TokenName;
import java.util.HashMap;

//Carter Copen
//This work follows the academic integrity policy

public class Parser {
	public static void main(String[] args) {
		String sentence = "eval 1 -> 0?";
		boolean value = new Parser().analyze(sentence);
		System.out.println(value);
	}
	
	private Queue<Token> tokens;
	HashMap<String, Boolean> lookupTable = new HashMap<String, Boolean>();
	
	public boolean analyze(String input) {
		tokens = new Lexer().tokenize(input);
		
		boolean value = program();
		expect(TokenName.END_OF_INPUT);
		
		return value; // TODO implement stub
	}

	//--------------------------------------------
	
	public boolean accept(TokenName name) {
		if (tokens.peek().name != name) {
			return false;
		} else {
			tokens.remove();
			return true;
		}
	}
	
	private boolean peek(TokenName name) {
		return tokens.peek().name == name;
	}
	
	private Object expect(TokenName name) {
		if (tokens.peek().name != name) {
			throw  new RuntimeException("Expected: " + name + ", but got: " + tokens.peek().name);
		}
		
		return tokens.remove().value;
	}
	
	//-----------------------------------------
	
	private boolean program() {
		
		assignment();
		
		return evaluation();
	}
	
	private void assignment() {
		
		while (accept(TokenName.LET_KEYWORD)){
			
			if (lookupTable != null && lookupTable.size() == 8) {
				throw new RuntimeException("lookupTable is full");
			}
			
			String var = variable();
			
			if (lookupTable != null && lookupTable.get(var) != null) {
				throw new RuntimeException("Variable Identifier Already Exsits");
			}
			
			expect(TokenName.EQUAL);
			boolean val = equivalence();
			expect(TokenName.COMMA);
			
			lookupTable.put(var, val);
		}
		
		return; 
	}
	
	private boolean evaluation() {
		
		expect(TokenName.EVAL_KEYWORD);
		
		boolean result = equivalence();
		
		expect(TokenName.QUESTION);
		
		return result;
	}
	
	private boolean equivalence() {
		boolean val = implication();
		while(accept(TokenName.DOUBLE_ARROW)) {
			val = (val == implication());
		}
		return val;
	}
	
	private boolean implication() {
		boolean val = disjunction();
		if(accept(TokenName.ARROW)) {
			val = !val | implication();
		}
		return val;
	}
	
	private boolean disjunction() {
		boolean val = conjunction();
		while(accept(TokenName.VEE)) {
			val = val | conjunction();
		}
		return val;
	}
	
	private boolean conjunction() {
		boolean val = negation();
		while(accept(TokenName.CARET)) {
			val = val & negation();
		}
		return val;
	}
	
	private boolean negation() {
		boolean val = expression();
		if(accept(TokenName.APOSTROPHE)) {
			return !val;
		}
		return val;
	}
	
	private boolean expression() {
		boolean val;
		if(accept(TokenName.OPEN_PAREN)) {
			val = equivalence();
			expect(TokenName.CLOSE_PAREN);
		} else {
			val = bool();
		}
		
		return val;
	}
	
	private boolean bool() {
		boolean val;
		if(peek(TokenName.BOOL_LITERAL)) {
			val = literal();
		} else {
			String var = variable();
			if (lookupTable.get(var) == null) {
				throw new RuntimeException("Variable Identifier Already Exsits");
			}
			val = lookupTable.get(var);
		}
		return val;
	}
	
	private boolean literal() {
		return (Boolean) expect(TokenName.BOOL_LITERAL);
	}
	
	private String variable() {
		return (String) expect(TokenName.IDENTIFIER);
	}
	
}
