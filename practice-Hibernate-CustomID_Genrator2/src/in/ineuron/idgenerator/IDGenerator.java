package in.ineuron.idgenerator;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class IDGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor arg0, Object arg1) throws HibernateException {
		String date = new SimpleDateFormat("yyyy-mm-dd").format(new Date());
		int nextInt = new Random().nextInt(1000);
		String prefix1 = "India-";
		String prefix2 = "Sandeep->";
		
		
		return prefix1 + date+ prefix2 +  nextInt;
	}

}
