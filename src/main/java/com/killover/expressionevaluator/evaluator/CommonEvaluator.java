package com.killover.expressionevaluator.evaluator;

import com.killover.expressionevaluator.base.ExpressionElement;
import com.killover.expressionevaluator.base.ExpressionEvaluator;
import com.killover.expressionevaluator.operand.Operand;
import com.killover.expressionevaluator.operand.VariableOperand;
import com.killover.expressionevaluator.operand.model.Variable;
import com.killover.expressionevaluator.operator.generator.OperatorGenerator;
import com.killover.expressionevaluator.parser.StringExpressionParser;

import java.util.List;
import java.util.Map;

/**
 * Created by ChenDaLin on 30/01/2018.
 */
public class CommonEvaluator {
    public static Operand value(String expression, Map<String, String> params) throws Exception{
        StringExpressionParser parser = new StringExpressionParser(StringExpressionParser.getDefaltOperatorWrapper());
        List<ExpressionElement> elements = parser.parse(expression);

        for(Map.Entry<String, String> field: params.entrySet()){
            String fieldName = field.getKey();
            String fieldValue = field.getValue();

            for (int i=0; i<elements.size(); ++i){
                ExpressionElement thisElement = elements.get(i);
                if (thisElement instanceof VariableOperand){
                    Variable variable = ((VariableOperand) thisElement).value();
                    if (fieldName.equals(variable.getName()))
                        elements.set(i, parser.generateOperand(fieldValue));
                }
            }
        }

        OperatorGenerator operatorGenerator = new OperatorGenerator();
        Operand result = ExpressionEvaluator.evaluate(elements, operatorGenerator);

        return result;
    }
}
