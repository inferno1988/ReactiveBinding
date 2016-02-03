// Generated from /home/atom/Projects/ReactiveBinding/app/grammar/ReactiveExpressions.g4 by ANTLR 4.5.1
package org.ifno_software.reactivebinding.parser;

import android.view.View;
import android.widget.TextView;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.ifno_software.reactivebinding.PropertyChangedEvent;
import org.ifno_software.reactivebinding.annotations.RxGetProperty;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import rx.Observable;

/**
 * This class provides an empty implementation of {@link ReactiveExpressionsListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class ReactiveExpressionsBaseListener implements ReactiveExpressionsListener {




	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEvaluatoinUnit(ReactiveExpressionsParser.EvaluatoinUnitContext ctx) {

	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEvaluatoinUnit(ReactiveExpressionsParser.EvaluatoinUnitContext ctx) { }

	@Override
	public void enterAction(ReactiveExpressionsParser.ActionContext ctx) {

	}

	@Override
	public void exitAction(ReactiveExpressionsParser.ActionContext ctx) {

	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) { }


}