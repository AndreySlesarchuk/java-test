package by.atmm.java.__tasks.__quiz.codewars;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.HashMap;
import java.util.Map;

public class CollectRequest {

  @PersistenceContext
  private EntityManager em;

  public static void main(String[] args) {
    Integer number = 1_234_567_890;
    int digitNumber = 1;

    System.out.println(
        "First - " + new CollectRequest().findProductExpenditures(1L, 2L, 3L, 4L, 5L, 6L));
  }

  public String findProductExpenditures(Long companyId, Long staffId, Long clientId,
      Long storehouseProductExpenditureId, Long storehouseProductId, Long appointmentId) {

    StringBuilder baseQuery = new StringBuilder(
        "select s from ProductExpenditure s where s.staff.company = ?1");

    Map<String, Long> parts = new HashMap<>();

    getQueryPart(parts, "staffId", staffId);
    getQueryPart(parts, "clientId", clientId);
    getQueryPart(parts, "storehouseProductExpenditureId", storehouseProductExpenditureId);
    getQueryPart(parts, "storehouseProductId", storehouseProductId);
    getQueryPart(parts, "appointmentId", appointmentId);
    int partNumber = 1;
    for (Map.Entry<String, Long> entry : parts.entrySet()) {
      baseQuery.append(getQueryPart(entry.getKey(), entry.getValue(), ++partNumber));
    }

    //Query query = em.createQuery(String.valueOf(baseQuery));
    partNumber = 1;
    for (Map.Entry<String, Long> entry : parts.entrySet()) {
      //query.setParameter(++partNumber, entry.getValue());
    }

    return baseQuery.toString();
  }

  private Map<String, Long> getQueryPart(Map<String, Long> parts, String part, Long value) {
      if (value != null) {
          parts.put(part, value);
      }
    return parts;
  }

  private String getQueryPart(String part, Long value, int partNum) {
    String qp = " and s." + part + " = ?" + partNum;
    return qp;
  }

}
