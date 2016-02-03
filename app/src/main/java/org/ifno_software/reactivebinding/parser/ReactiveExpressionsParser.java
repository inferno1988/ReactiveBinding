// Generated from /home/atom/Projects/ReactiveBinding/app/grammar/ReactiveExpressions.g4 by ANTLR 4.5.1
package org.ifno_software.reactivebinding.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ReactiveExpressionsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		OPEN=1, CLOSE=2, SUBSCRIBE=3, COMMAND=4, Identifier=5, WS=6;
	public static final int
		RULE_evaluatoinUnit = 0, RULE_action = 1;
	public static final String[] ruleNames = {
		"evaluatoinUnit", "action"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'subscribe'", "'command'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "OPEN", "CLOSE", "SUBSCRIBE", "COMMAND", "Identifier", "WS"
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

	@Override
	public String getGrammarFileName() { return "ReactiveExpressions.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ReactiveExpressionsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EvaluatoinUnitContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(ReactiveExpressionsParser.OPEN, 0); }
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(ReactiveExpressionsParser.Identifier, 0); }
		public TerminalNode CLOSE() { return getToken(ReactiveExpressionsParser.CLOSE, 0); }
		public EvaluatoinUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_evaluatoinUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReactiveExpressionsListener ) ((ReactiveExpressionsListener)listener).enterEvaluatoinUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReactiveExpressionsListener ) ((ReactiveExpressionsListener)listener).exitEvaluatoinUnit(this);
		}
	}

	public final EvaluatoinUnitContext evaluatoinUnit() throws RecognitionException {
		EvaluatoinUnitContext _localctx = new EvaluatoinUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_evaluatoinUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(4);
			match(OPEN);
			setState(5);
			action();
			setState(6);
			match(Identifier);
			setState(7);
			match(CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActionContext extends ParserRuleContext {
		public TerminalNode SUBSCRIBE() { return getToken(ReactiveExpressionsParser.SUBSCRIBE, 0); }
		public TerminalNode COMMAND() { return getToken(ReactiveExpressionsParser.COMMAND, 0); }
		public ActionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_action; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReactiveExpressionsListener ) ((ReactiveExpressionsListener)listener).enterAction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReactiveExpressionsListener ) ((ReactiveExpressionsListener)listener).exitAction(this);
		}
	}

	public final ActionContext action() throws RecognitionException {
		ActionContext _localctx = new ActionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_action);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9);
			_la = _input.LA(1);
			if ( !(_la==SUBSCRIBE || _la==COMMAND) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\b\16\4\2\t\2\4\3"+
		"\t\3\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\2\2\4\2\4\2\3\3\2\5\6\13\2\6\3\2"+
		"\2\2\4\13\3\2\2\2\6\7\7\3\2\2\7\b\5\4\3\2\b\t\7\7\2\2\t\n\7\4\2\2\n\3"+
		"\3\2\2\2\13\f\t\2\2\2\f\5\3\2\2\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}