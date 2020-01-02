package etc;

import java.util.HashMap;
import java.util.Map;

/*LRU Cache algorithm 구현
 *LRU(Least Recently Used) : 가장 오랫동안 사용되지 않은 페이지를 교체하는 알고리즘
 * double linked list 사용
 * map 사용 : 노드를 탐색하는 속도가 O(1)이기 때문이다.
 * Head와 Tail 노드는 data를 가지고 있는 것이 아니고 포인터의 역할만 한다.
 * 즉, head.next 값이 실제 리스트에 최근에 추가된 원소가 되고, Tail.prev 값이 실제 리스트의 가장 오래된 원소가 된다.
*/
public class LRUCache {
	private Map<Integer, node> nodeMap;
	private int capacity;
	private node head;
	private node tail;

	private class node {
		private int key;
		private int value;
		private node prev;
		private node next;

		public node(int key, int value) {
			this.key = key;
			this.value = value;
			this.next = null;
			this.prev = null;
		}
	}

	public LRUCache(int capacity) {
		this.nodeMap = new HashMap<>();
		this.capacity = capacity;
		head = new node(0, 0);
		tail = new node(0, 0);
		head.next = tail;
		tail.prev = head;

	}

	//시간 복잡도 O(1)
	private void remove(node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;

		nodeMap.remove(node.key);
	}

	//시간 복잡도 O(1)
	private void insertToHead(node node) {
		this.head.next.prev = node;
		node.next = this.head.next;
		node.prev = this.head;
		this.head.next = node;

		nodeMap.put(node.key, node);
	}

	//시간 복잡도 O(1)
	public int get(int key) {
		if (!nodeMap.containsKey(key))
			return -1;
		node getNode = nodeMap.get(key);
		remove(getNode);
		insertToHead(getNode);
		return getNode.value;

	}

	//시간 복잡도 O(1)
	public void put(int key, int value) {
		node newNode = new node(key, value);
		if (nodeMap.containsKey(key)) {
			node oldNode = nodeMap.get(key);
			remove(oldNode);
		} else {
			if (nodeMap.size() >= this.capacity) {
				node delNode = tail.prev;
				remove(delNode);
			}
		}
		insertToHead(newNode);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
