// Generated from /home/atom/Projects/ReactiveBinding/app/grammar/ReactiveExpressions.g4 by ANTLR 4.5.1
package org.ifno_software.reactivebinding.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ReactiveExpressionsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OPEN=1, CLOSE=2, SUBSCRIBE=3, COMMAND=4, LINK=5, Identifier=6, WS=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"OPEN", "CLOSE", "SUBSCRIBE", "COMMAND", "LINK", "Identifier", "JavaLetter", 
		"JavaLetterOrDigit", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'subscribe'", "'command'", "'->'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "OPEN", "CLOSE", "SUBSCRIBE", "COMMAND", "LINK", "Identifier", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public ReactiveExpressionsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ReactiveExpressions.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return JavaLetter_sempred((RuleContext)_localctx, predIndex);
		case 7:
			return JavaLetterOrDigit_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean JavaLetter_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return Character.isJavaIdentifierStart(_input.LA(-1));
		case 1:
			return Character.isJavaIdentifierStart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)));
		}
		return true;
	}
	private boolean JavaLetterOrDigit_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return Character.isJavaIdentifierPart(_input.LA(-1));
		case 3:
			return Character.isJavaIdentifierPart(Character.toCodePoint((char)_input.LA(-2), (char)_input.LA(-1)));
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\tL\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\7\7\61\n\7\f\7\16\7\64\13\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\b<\n\b\3\t\3\t\3\t\3\t\3\t\3\t\5\tD\n\t\3\n\6\nG\n\n\r"+
		"\n\16\nH\3\n\3\n\2\2\13\3\3\5\4\7\5\t\6\13\7\r\b\17\2\21\2\23\t\3\2\b"+
		"\6\2&&C\\aac|\4\2\2\u0081\ud802\udc01\3\2\ud802\udc01\3\2\udc02\ue001"+
		"\7\2&&\62;C\\aac|\5\2\13\f\16\17\"\"O\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\23\3\2\2\2\3\25\3\2\2\2\5"+
		"\27\3\2\2\2\7\31\3\2\2\2\t#\3\2\2\2\13+\3\2\2\2\r.\3\2\2\2\17;\3\2\2\2"+
		"\21C\3\2\2\2\23F\3\2\2\2\25\26\7}\2\2\26\4\3\2\2\2\27\30\7\177\2\2\30"+
		"\6\3\2\2\2\31\32\7u\2\2\32\33\7w\2\2\33\34\7d\2\2\34\35\7u\2\2\35\36\7"+
		"e\2\2\36\37\7t\2\2\37 \7k\2\2 !\7d\2\2!\"\7g\2\2\"\b\3\2\2\2#$\7e\2\2"+
		"$%\7q\2\2%&\7o\2\2&\'\7o\2\2\'(\7c\2\2()\7p\2\2)*\7f\2\2*\n\3\2\2\2+,"+
		"\7/\2\2,-\7@\2\2-\f\3\2\2\2.\62\5\17\b\2/\61\5\21\t\2\60/\3\2\2\2\61\64"+
		"\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\16\3\2\2\2\64\62\3\2\2\2\65<\t"+
		"\2\2\2\66\67\n\3\2\2\67<\6\b\2\289\t\4\2\29:\t\5\2\2:<\6\b\3\2;\65\3\2"+
		"\2\2;\66\3\2\2\2;8\3\2\2\2<\20\3\2\2\2=D\t\6\2\2>?\n\3\2\2?D\6\t\4\2@"+
		"A\t\4\2\2AB\t\5\2\2BD\6\t\5\2C=\3\2\2\2C>\3\2\2\2C@\3\2\2\2D\22\3\2\2"+
		"\2EG\t\7\2\2FE\3\2\2\2GH\3\2\2\2HF\3\2\2\2HI\3\2\2\2IJ\3\2\2\2JK\b\n\2"+
		"\2K\24\3\2\2\2\7\2\62;CH\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}