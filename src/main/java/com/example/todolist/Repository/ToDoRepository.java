package com.example.todolist.Repository;

import com.example.todolist.Entity.ToDo;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ToDoRepository {

    // 엔티티를 관리해주는 엔티티 매니저
    private final EntityManager em;

    // 데이터를 저장한다.
    public void save(ToDo todo) {
        if (todo.getId() == null) {
            em.persist(todo);
        } else {
            em.merge(todo); // 이 부분이 update를 도와주는 코드
        }
    }

    // 데이터를 id로 하나만 조회한다.
    public ToDo findOne(Long id) {
        return em.find(ToDo.class, id);
    }

    // 저장된 모든 데이터를 조회한다.
    public List<ToDo> findAll() {
        return em.createQuery("select i from ToDo i", ToDo.class)
                .getResultList();
    }

    // 삭제 코드 추가
    public void delete(ToDo todo) {
        em.remove(todo);
    }

}

