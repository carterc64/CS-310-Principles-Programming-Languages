package unit;

import java.util.LinkedList;
import java.util.Queue;

import framework.Token;
import framework.TokenName;

//Carter Copen
//This work follows the academic integrity policy

public class Lexer {
	public static void main(String[] args) {
		String sentence = "eval 1 ?";
		//String sentence = "letasj";
		Queue<Token> tokens = new Lexer().tokenize(sentence);
		while (!tokens.isEmpty())
			System.out.println(tokens.remove());
	}

	public Queue<Token> tokenize(String input) {
		Queue<Token> tokens = new LinkedList<Token>();
		char ch;
		
		for (int i = 0; i < input.length(); i++) {

			ch = input.charAt(i);
			
			if(Character.isWhitespace(ch)) {
				continue;
			}
			
			if (ch == '=') {
				tokens.add(new Token (TokenName.EQUAL));
				
			} else if (ch == ',') {
				tokens.add(new Token (TokenName.COMMA));
				
			} else if (ch == '?') {
				tokens.add(new Token (TokenName.QUESTION));
				
			} else if (ch == '<') {
				if (i+2 < input.length() && input.charAt(i+1) == '-' && input.charAt(i+2) == '>') {
					tokens.add(new Token (TokenName.DOUBLE_ARROW));
					i += 2;
				} else {
					tokens.add(new Token (TokenName.UNEXPECTED_INPUT));
					return tokens;
				}
				
			} else if (ch == '-') {
				if (i+1 < input.length() && input.charAt(i+1) == '>' ) {
					tokens.add(new Token (TokenName.ARROW));
					i++;
				} else {
					tokens.add(new Token (TokenName.UNEXPECTED_INPUT));
					return tokens;
				}
				
			}else if (ch == '^') {
				tokens.add(new Token (TokenName.CARET));
				
			}else if (ch == '\''){
				tokens.add(new Token (TokenName.APOSTROPHE));
			
			} else if (ch == '(') {
				tokens.add(new Token (TokenName.OPEN_PAREN));
				
			} else if (ch == ')') {
				tokens.add(new Token (TokenName.CLOSE_PAREN));
				
			} else if (ch == '1' || ch == '0') {
				if(ch == '1') {
					tokens.add(new Token (TokenName.BOOL_LITERAL, true));
				} else {
					tokens.add(new Token (TokenName.BOOL_LITERAL, false));
				}
	
				
			} else if (Character.isLetter(ch)){
				int len = 1;
				while (i+len < input.length() && Character.isLetter(input.charAt(i+len))) {
					len++;
				}
				String lexeme = input.substring(i, i+len);
				if (lexeme.toLowerCase().equals("let")) {
					tokens.add(new Token (TokenName.LET_KEYWORD));
				} else if (lexeme.toLowerCase().equals("eval")) {
					tokens.add(new Token(TokenName.EVAL_KEYWORD));
				} else if (lexeme.toLowerCase().equals("v")) {
					tokens.add(new Token(TokenName.VEE));
				} else {
					tokens.add(new Token(TokenName.IDENTIFIER, lexeme));
				}
				
				i += len-1;
			
			}else {
				tokens.add(new Token (TokenName.UNEXPECTED_INPUT));
				return tokens;
			}
		}
		
		
		
		
		
		tokens.add(new Token (TokenName.END_OF_INPUT));
		return tokens; // TODO implement stub
	}
}