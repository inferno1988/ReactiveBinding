// Generated from /home/atom/Projects/ReactiveBinding/app/grammar/ReactiveExpressions.g4 by ANTLR 4.5.1
package org.ifno_software.reactivebinding.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ReactiveExpressionsParser}.
 */
public interface ReactiveExpressionsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ReactiveExpressionsParser#evaluationUnit}.
	 * @param ctx the parse tree
	 */
	void enterEvaluationUnit(ReactiveExpressionsParser.EvaluationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactiveExpressionsParser#evaluationUnit}.
	 * @param ctx the parse tree
	 */
	void exitEvaluationUnit(ReactiveExpressionsParser.EvaluationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactiveExpressionsParser#evaluationSequence}.
	 * @param ctx the parse tree
	 */
	void enterEvaluationSequence(ReactiveExpressionsParser.EvaluationSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactiveExpressionsParser#evaluationSequence}.
	 * @param ctx the parse tree
	 */
	void exitEvaluationSequence(ReactiveExpressionsParser.EvaluationSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactiveExpressionsParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(ReactiveExpressionsParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactiveExpressionsParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(ReactiveExpressionsParser.ActionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactiveExpressionsParser#bindExpression}.
	 * @param ctx the parse tree
	 */
	void enterBindExpression(ReactiveExpressionsParser.BindExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactiveExpressionsParser#bindExpression}.
	 * @param ctx the parse tree
	 */
	void exitBindExpression(ReactiveExpressionsParser.BindExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactiveExpressionsParser#attrName}.
	 * @param ctx the parse tree
	 */
	void enterAttrName(ReactiveExpressionsParser.AttrNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactiveExpressionsParser#attrName}.
	 * @param ctx the parse tree
	 */
	void exitAttrName(ReactiveExpressionsParser.AttrNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ReactiveExpressionsParser#propertyName}.
	 * @param ctx the parse tree
	 */
	void enterPropertyName(ReactiveExpressionsParser.PropertyNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactiveExpressionsParser#propertyName}.
	 * @param ctx the parse tree
	 */
	void exitPropertyName(ReactiveExpressionsParser.PropertyNameContext ctx);
}