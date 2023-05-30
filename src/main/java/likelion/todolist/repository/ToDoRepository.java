package likelion.todolist.repository;

import jakarta.persistence.EntityManager;
import likelion.todolist.entity.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ToDoRepository {

    private final EntityManager em;

    public void save(ToDo todo) {
        if (todo.getId() == null) {
            em.persist(todo);
        } else {
            em.merge(todo);
        }
    }

    // 삭제 코드 추가
    public void delete(ToDo todo) {
        em.remove(todo);
    }

    public ToDo findOne(Long id) {
        return em.find(ToDo.class, id);
    }

    public List<ToDo> findAll() {
        return em.createQuery("select i from ToDo i", ToDo.class)
                .getResultList();
    }
}