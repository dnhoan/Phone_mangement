
package DAL.IServices;

import java.util.List;

public interface IPhoneMangementService<EntityType, KeyType> {
    abstract public void insert(EntityType entity);

    abstract public void update(EntityType entity);

    abstract public void delete(KeyType id);

    abstract public EntityType selectByID(KeyType id);

    abstract public List<EntityType> selectAll();

    abstract public List<EntityType> selectBySql(String sql, Object... args); 
}
