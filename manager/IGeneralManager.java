package manager;

import java.io.IOException;

public interface IGeneralManager<E> {
    void save(E e) throws IOException;
    void remove(E e) throws IOException;
    void update(int index,E e) throws IOException;
    E search(String id);
}
