// Generated from /home/atom/Projects/ReactiveBinding/app/grammar/ReactiveExpressions.g4 by ANTLR 4.5.1
package org.ifno_software.reactivebinding.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ReactiveExpressionsParser}.
 */
public interface ReactiveExpressionsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ReactiveExpressionsParser#evaluatoinUnit}.
	 * @param ctx the parse tree
	 */
	void enterEvaluatoinUnit(ReactiveExpressionsParser.EvaluatoinUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ReactiveExpressionsParser#evaluatoinUnit}.
	 * @param ctx the parse tree
	 */
	void exitEvaluatoinUnit(ReactiveExpressionsParser.EvaluatoinUnitContext ctx);
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
}