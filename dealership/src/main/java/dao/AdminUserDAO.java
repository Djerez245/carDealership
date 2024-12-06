package dao;

import com.pluralsight.Contract;
import com.pluralsight.LeaseContract;
import com.pluralsight.SalesContract;


public interface AdminUserDAO {
    void addSale(SalesContract salesContract);
    void addLease(LeaseContract leaseContract);
}
