package by.tms.dao;

import by.tms.entity.Operation;
import java.util.List;

public interface CalcDao {
    void saveOperation(Operation operation);
    List<Operation> getOperations();
}
