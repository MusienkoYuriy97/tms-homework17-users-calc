package by.tms.service;

import by.tms.dao.DaoHistory;
import by.tms.dao.DaoHistoryImp;
import by.tms.entity.Calculator;
import by.tms.entity.Operation;
import by.tms.exeptions.calc.OperationsNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService {
    DaoHistory daoHistory = new DaoHistoryImp();

    public List<Operation> getOperation() {
        return new ArrayList<>(daoHistory.getOperations());
    }

    public double selectCommand(String command, double x, double y, String username) throws OperationsNotFoundException {
        double result;
        switch (command){
            case "sum":
                result = Calculator.sum(x,y);
                daoHistory.saveOperation(new Operation(x,y,result,command,username));
                return result;
            case "sub":
                result = Calculator.sub(x,y);
                daoHistory.saveOperation(new Operation(x,y,result,command,username));
                return result;
            case "div":
                result = Calculator.division(x,y);
                daoHistory.saveOperation(new Operation(x,y,result,command,username));
                return result;
            case "mul":
                result = Calculator.multiply(x,y);
                daoHistory.saveOperation(new Operation(x,y,result,command,username));
                return result;
            default:
                throw new OperationsNotFoundException("Operation not found");
        }
    }
}
