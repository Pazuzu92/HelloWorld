package lesson02.task02;



import java.util.*;

import static java.util.Objects.hash;

public class MyHashMap<K,V> implements Map<K,V> {


    static class Node<K,V> {
        K key;
        V value;
        int hash;
        Node<K,V> nextNode;

        public Node(int hash, K key, V value, Node<K, V> nextNode) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.nextNode = nextNode;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?, ?> node = (Node<?, ?>) o;
            return key.equals(node.key) &&
                    Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    Node<K,V>[] node;
    int size = 0;

    public MyHashMap() {
        node = new Node[16];
    }

    private int hash(Object key) {
        return key.hashCode() % 16;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(Object key) {
        if (node != null) {
            for (int i = 0; i < node.length; i++) {
                for (Node<K,V> currNode = node[i]; currNode != null ; currNode = currNode.nextNode) {
                    if (currNode.key == key || currNode.value.equals(key)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean containsValue(Object value) {
        if (node != null) {
            for (int i = 0; i < node.length; i++) {
                for (Node<K,V> currNode = node[i]; currNode != null ; currNode = currNode.nextNode) {
                    if (currNode.value == value || currNode.value.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public V get(Object key) {
        Node<K,V> node;
        if ((node =getNode(hash(key), key)) == null) {
            return null;
        } else {
            return node.value;
        }
    }


    Node<K, V> getNode(int hash, Object key) {
        Node<K,V>[] nodes;
        Node<K,V> firstNode, nextNode;
        int arrayLength;

        if ((nodes = node) != null && (arrayLength = nodes.length) > 0 &&
                (firstNode = nodes[(arrayLength - 1) & hash]) != null) {
            if (firstNode.hash == hash &&
                    (Objects.equals(key, firstNode.key)))
                return firstNode;
            if ((nextNode = firstNode.nextNode) != null) {
                if (nextNode.hash == hash &&
                        (Objects.equals(key, nextNode.key)))
                    return nextNode;
                while ((nextNode = nextNode.nextNode) != null) {
                    if (nextNode.hash == hash &&
                            (Objects.equals(key, nextNode.key)))
                        return nextNode;
                }
            }
        }
        return null;
    }


    @Override
    public V put(K key, V value) {
        int hash = hash(key);
        Node<K,V>[] nodes = node;
        Node<K,V> firstNode;
        V firstValue;
        int index = (nodes.length - 1) & hash;

        if ((firstNode = nodes[index]) == null) {
            nodes[index] = newNode(hash, key, value, null);
            size++;
        } else {

            if (firstNode.hash == hash &&
                    ((firstNode.key.equals(key)) || firstNode.key == key)) {
                firstNode.value = value;
                return firstNode.value;
            }

            if (firstNode.hash != hash && firstNode != null) {
                firstValue = firstNode.value;
                if(firstValue == null) {
                    firstNode.value = value;
                }
                size++;
                return firstValue;
            }
        }

        return null;
    }

    public V remove(Object key) {
        int hash = hash(key);
        Node<K,V>[] nodes = node;
        Node<K,V> firstNode;
        V value = null;
        Node<K,V> nullNode = null, nextNode;
        int index = (nodes.length - 1) & hash;

        if ((firstNode = node[index])!= null ) {
            if (firstNode.hash == hash && ((firstNode.key.equals(key)) || firstNode.key == key)) {
                firstNode.key = null;
                size--;
            }
            if ((nextNode = firstNode.nextNode) != null) {
                while ((nextNode = nextNode.nextNode) != null){
                    if (nextNode.hash == hash &&
                            (Objects.equals(key, nextNode.key))) {
                        nullNode = nextNode;
                        break;
                    }
                    firstNode = nextNode;
                }
            }
            if (nullNode != null && (Objects.equals(value, nullNode.value))) {
                if (nullNode == firstNode)
                    nodes[index] = nullNode.nextNode;
                else
                    firstNode.nextNode = nullNode.nextNode;

                --size;
                return nullNode.value;
            }
        }
        return null;
    }

    public void putAll(Map m){
        throw new UnsupportedOperationException("putAll is not realised");
    }


    public void clear() {
        try {
            throw new MethodIsNotRealisedException("clear is not realised");
        } catch (MethodIsNotRealisedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    Node<K,V> newNode(int hash, K key, V value, Node<K,V> next) {
        return new Node<>(hash, key, value, next);
    }
}
