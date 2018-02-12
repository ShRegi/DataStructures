package datastructures.shavaleevar.datastructures.maps;

import java.util.HashMap;
import java.util.Map;

public class HashMatrix<V> implements Matrix<V> {
    private Map<Key ,V> matrix;

    HashMatrix() {
        this(0);
    }

    HashMatrix(int length) {
        matrix = new HashMap<>(length);
    }

    private static class Key {
        private final int x;
        private final int y;

        Key(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Key)) {
                return false;
            }
            Key key = (Key) o;
            return x == key.x && y == key.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }

    @Override
    public V get(int i, int j) {
        return matrix.get(new Key(i, j));
    }

    @Override
    public void set(int i, int j, V value) {
        matrix.put(new Key(i, j), value);
    }
}
