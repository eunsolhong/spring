package repository;

import dao.Item;

public interface ItemRepository {

	Item findById(Integer itemId);

}
