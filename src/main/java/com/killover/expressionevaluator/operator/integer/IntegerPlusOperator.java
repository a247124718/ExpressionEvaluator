package com.killover.expressionevaluator.operator.integer;

import com.killover.expressionevaluator.operand.IntegerOperand;
import com.killover.expressionevaluator.operand.Operand;
import com.killover.expressionevaluator.operator.BinaryOperator;

/**
 * Created by killover on 2016/11/1.
 */
public class IntegerPlusOperator extends BinaryOperator<Integer, Integer, Integer> {
    private static final int OPERATOR_PRIORITY_INTEGER_PLUS = 3;

    public IntegerPlusOperator(){
        super(OPERATOR_PRIORITY_INTEGER_PLUS);
    }

    @Override
    public Operand<Integer> operate(Operand<Integer> operand1, Operand<Integer> operand2){
        return new IntegerOperand(operand1.value() + operand2.value());
    }
}
