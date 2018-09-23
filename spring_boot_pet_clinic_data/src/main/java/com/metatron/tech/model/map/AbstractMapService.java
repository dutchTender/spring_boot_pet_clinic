package com.metatron.tech.model.map;


import com.metatron.tech.model.BaseEntity;


import java.util.*;


public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object){
        if(object != null){
            if(object.getId() == null){
                object.setId(getNextID());
            }
        }
        else{
            throw new RuntimeException("object can not be null");
        }

        map.put(object.getId(),object);

        return object;
    }

    void deleteById(ID id)
    {
        map.remove(id);
    }


    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));

    }

    private Long getNextID(){

        Long nextID;
        if(map.size() > 0) { nextID = Collections.max(map.keySet()) + 1;
        }
        else
        {
           nextID = 1L;
        }
        return nextID;

    }
}
