package by.atmm.java.__early.other.collections;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import by.atmm.java.__early.other.utils.Watch;

public class CollectRequest {

    @PersistenceContext
    private EntityManager em;

    public static void main(String[] args) {

      Watch watch = new Watch();
      Integer number = 1_234_567_890;
      int digitNumber = 1;
      watch.start();

      System.out.println("First - " + new CollectRequest()
          .findProductExpenditures(1L, 2L,null, 4L, 5L, 6L));
      watch.totalTime("Collection time = ");

    }

  public String findProductExpenditures (Long companyId, Long staffId, Long clientId,
      Long storehouseProductExpenditureId, Long storehouseProductId, Long appointmentId) {
    int parameterNum = 1;
    final String BASE_QUERY = "select s from ProductExpenditure s where s.staff.company = ?1";
    final String STAFF = getQueryPart("staffId", staffId, ++parameterNum);
    final String CLIENT = clientId != null ? getQueryPart("clientId", clientId, ++parameterNum) : "";
    final String STOREHOUSE_PRODUCT_EXPENDITURE = getQueryPart("storehouseProductExpenditureId", storehouseProductExpenditureId, ++parameterNum);
    final String STOREHOUSE_PRODUCT = getQueryPart("storehouseProductId", storehouseProductId, ++parameterNum);
    final String APPOINTMENT = getQueryPart("appointmentId", appointmentId, ++parameterNum);


    String requestString = BASE_QUERY+STAFF+CLIENT+ STOREHOUSE_PRODUCT_EXPENDITURE+STOREHOUSE_PRODUCT+APPOINTMENT;
    return requestString;
  }

  private String getQueryPart(String part, Long value, int partNum) {
    String qp = value != null ? " and s." + part + " = ?" + partNum : "";
    return qp;
  }



}
