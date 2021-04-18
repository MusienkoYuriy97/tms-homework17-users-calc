package by.tms.service;

import by.tms.dao.CalcDao;
import by.tms.dao.CalcDaoImp;
import by.tms.entity.Calculator;
import by.tms.entity.Operation;
import by.tms.exeptions.calc.OperationsNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService {
    CalcDao calcDao = new CalcDaoImp();

    public List<Operation> getOperation() {
        return new ArrayList<>(calcDao.getOperations());
    }

    public double selectCommand(String command, double x, double y, String username) throws OperationsNotFoundException {
        double result;
        switch (command){
            case "sum":
                result = Calculator.sum(x,y);
                calcDao.saveOperation(new Operation(x,y,result,command,username));
                return result;
            case "sub":
                result = Calculator.sub(x,y);
                calcDao.saveOperation(new Operation(x,y,result,command,username));
                return result;
            case "div":
                result = Calculator.division(x,y);
                calcDao.saveOperation(new Operation(x,y,result,command,username));
                return result;
            case "mul":
                result = Calculator.multiply(x,y);
                calcDao.saveOperation(new Operation(x,y,result,command,username));
                return result;
            default:
                throw new OperationsNotFoundException("Operation not found");
        }
    }
}
