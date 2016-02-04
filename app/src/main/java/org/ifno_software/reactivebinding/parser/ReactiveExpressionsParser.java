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
		OPEN=1, CLOSE=2, SUBSCRIBE=3, COMMAND=4, LINK=5, Identifier=6, WS=7;
	public static final int
		RULE_evaluationUnit = 0, RULE_evaluationSequence = 1, RULE_action = 2, 
		RULE_bindExpression = 3, RULE_attrName = 4, RULE_propertyName = 5;
	public static final String[] ruleNames = {
		"evaluationUnit", "evaluationSequence", "action", "bindExpression", "attrName", 
		"propertyName"
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
	public static class EvaluationUnitContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(ReactiveExpressionsParser.OPEN, 0); }
		public ActionContext action() {
			return getRuleContext(ActionContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(ReactiveExpressionsParser.CLOSE, 0); }
		public TerminalNode Identifier() { return getToken(ReactiveExpressionsParser.Identifier, 0); }
		public BindExpressionContext bindExpression() {
			return getRuleContext(BindExpressionContext.class,0);
		}
		public EvaluationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_evaluationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReactiveExpressionsListener ) ((ReactiveExpressionsListener)listener).enterEvaluationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReactiveExpressionsListener ) ((ReactiveExpressionsListener)listener).exitEvaluationUnit(this);
		}
	}

	public final EvaluationUnitContext evaluationUnit() throws RecognitionException {
		EvaluationUnitContext _localctx = new EvaluationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_evaluationUnit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			match(OPEN);
			setState(13);
			action();
			setState(16);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(14);
				match(Identifier);
				}
				break;
			case 2:
				{
				setState(15);
				bindExpression();
				}
				break;
			}
			setState(18);
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

	public static class EvaluationSequenceContext extends ParserRuleContext {
		public List<EvaluationUnitContext> evaluationUnit() {
			return getRuleContexts(EvaluationUnitContext.class);
		}
		public EvaluationUnitContext evaluationUnit(int i) {
			return getRuleContext(EvaluationUnitContext.class,i);
		}
		public EvaluationSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_evaluationSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReactiveExpressionsListener ) ((ReactiveExpressionsListener)listener).enterEvaluationSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReactiveExpressionsListener ) ((ReactiveExpressionsListener)listener).exitEvaluationSequence(this);
		}
	}

	public final EvaluationSequenceContext evaluationSequence() throws RecognitionException {
		EvaluationSequenceContext _localctx = new EvaluationSequenceContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_evaluationSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			evaluationUnit();
			setState(22);
			_la = _input.LA(1);
			if (_la==OPEN) {
				{
				setState(21);
				evaluationUnit();
				}
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
		enterRule(_localctx, 4, RULE_action);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
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

	public static class BindExpressionContext extends ParserRuleContext {
		public AttrNameContext attrName() {
			return getRuleContext(AttrNameContext.class,0);
		}
		public TerminalNode LINK() { return getToken(ReactiveExpressionsParser.LINK, 0); }
		public PropertyNameContext propertyName() {
			return getRuleContext(PropertyNameContext.class,0);
		}
		public BindExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bindExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReactiveExpressionsListener ) ((ReactiveExpressionsListener)listener).enterBindExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReactiveExpressionsListener ) ((ReactiveExpressionsListener)listener).exitBindExpression(this);
		}
	}

	public final BindExpressionContext bindExpression() throws RecognitionException {
		BindExpressionContext _localctx = new BindExpressionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_bindExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			attrName();
			setState(27);
			match(LINK);
			setState(28);
			propertyName();
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

	public static class AttrNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(ReactiveExpressionsParser.Identifier, 0); }
		public AttrNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReactiveExpressionsListener ) ((ReactiveExpressionsListener)listener).enterAttrName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReactiveExpressionsListener ) ((ReactiveExpressionsListener)listener).exitAttrName(this);
		}
	}

	public final AttrNameContext attrName() throws RecognitionException {
		AttrNameContext _localctx = new AttrNameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attrName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			match(Identifier);
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

	public static class PropertyNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(ReactiveExpressionsParser.Identifier, 0); }
		public PropertyNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ReactiveExpressionsListener ) ((ReactiveExpressionsListener)listener).enterPropertyName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ReactiveExpressionsListener ) ((ReactiveExpressionsListener)listener).exitPropertyName(this);
		}
	}

	public final PropertyNameContext propertyName() throws RecognitionException {
		PropertyNameContext _localctx = new PropertyNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_propertyName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(Identifier);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\t%\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\2\5\2\23\n\2\3\2\3\2"+
		"\3\3\3\3\5\3\31\n\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\2\2\b"+
		"\2\4\6\b\n\f\2\3\3\2\5\6 \2\16\3\2\2\2\4\26\3\2\2\2\6\32\3\2\2\2\b\34"+
		"\3\2\2\2\n \3\2\2\2\f\"\3\2\2\2\16\17\7\3\2\2\17\22\5\6\4\2\20\23\7\b"+
		"\2\2\21\23\5\b\5\2\22\20\3\2\2\2\22\21\3\2\2\2\23\24\3\2\2\2\24\25\7\4"+
		"\2\2\25\3\3\2\2\2\26\30\5\2\2\2\27\31\5\2\2\2\30\27\3\2\2\2\30\31\3\2"+
		"\2\2\31\5\3\2\2\2\32\33\t\2\2\2\33\7\3\2\2\2\34\35\5\n\6\2\35\36\7\7\2"+
		"\2\36\37\5\f\7\2\37\t\3\2\2\2 !\7\b\2\2!\13\3\2\2\2\"#\7\b\2\2#\r\3\2"+
		"\2\2\4\22\30";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}