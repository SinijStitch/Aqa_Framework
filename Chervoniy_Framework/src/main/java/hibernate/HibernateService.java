package hibernate;

import entity.LoginData;
import entity.PriceData;
import org.hibernate.Session;

import java.util.List;

public class HibernateService {
    public static Object[][] getLoginTestData() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<LoginData> loginData = session.createQuery("SELECT d FROM LoginData d", LoginData.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return loginData.stream()
                .map(ld -> new Object[]{ld.getUsername(), ld.getPassword()})
                .toArray(Object[][]::new);
    }

    public static Object[][] getPriceData(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<PriceData> priceData = session.createQuery("SELECT d FROM PriceData d", PriceData.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return priceData.stream()
                .map(pd ->new Object[]{pd.getItem_name(), pd.getPrice()})
                .toArray(Object[][]::new);
    }
}
