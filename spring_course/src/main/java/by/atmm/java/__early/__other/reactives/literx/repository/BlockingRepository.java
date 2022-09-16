package by.atmm.java.__early.__other.reactives.literx.repository;

public interface BlockingRepository<T> {

	void save(T value);

	T findFirst();

	Iterable<T> findAll();

	T findById(String id);
}