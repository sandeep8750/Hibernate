package in.ineuron.test;

import java.util.List;
import javax.persistence.ParameterMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.procedure.ProcedureCall;
import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

/** 
 * CREATE DEFINER=`root`@`localhost` PROCEDURE `P_GET_PRODUCT_BY_NAME`(IN name1 VARCHAR(20), IN name2 VARCHAR(20))
BEGIN 
  SELECT pid, pname, price, qty 
  FROM hibernate.products 
  WHERE pname IN (name1, name2); 
END
 *
 */
public class SelectApp {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            String product1 = "fossils";
            String product2 = "FastRack";

            // Creating a Procedure call object
            ProcedureCall procedureCall = session.createStoredProcedureCall("P_GET_PRODUCT_BY_NAME", Product.class);

            // Binding input parameter value for Procedure call object
            procedureCall.registerParameter(1, String.class, ParameterMode.IN).bindValue(product1);
            procedureCall.registerParameter(2, String.class, ParameterMode.IN).bindValue(product2);

            // Executing the store procedure to get the result
            List<Product> products = procedureCall.getResultList();

            // Check if any products were returned
            if (products.isEmpty()) {
                System.out.println("No products found.");
            } else {
                // Processing the result
                products.forEach(System.out::println);
            }

        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
            HibernateUtil.closeSessionFactory();
        }
    }
}
