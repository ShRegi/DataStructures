package datastructures.shavaleevar.datastructures.maps;

import static datastructures.util.Assert.assertEquals;
import static datastructures.util.Assert.fail;

import java.util.NoSuchElementException;

@SuppressWarnings("SpellCheckingInspection")
public class AssociativeArrayTest {
    public static void main(String[] args) {
        testAdd();
        testGet();
        testGetNull();
        testGetException();
        testRemove();
        testRemoveNull();
        testPolygenlubricants();

        AssociativeArray<String, String> actual = new AssociativeArray<>(15);
        actual.add("accismus toddlertoddy", "A");
        actual.add("acephalisthematolysis", "A");
        actual.add("c", "A");
        actual.add("ACETOMORPHINE ACHENE", "A");
        actual.add("e", "A");
        actual.add("f", "A");
        actual.add("g", "A");
        actual.add("h", "A");
        actual.add("i", "A");
        actual.add("j", "A");
        actual.add("k", "A");
        actual.add("l", "A");
        actual.add(null, "5");
        actual.add("m", "A");
        actual.add("n", "A");
        actual.add("o", "A");
        actual.add("p", "A");
        actual.add("q", "A");
        actual.add("r", "A");
        actual.add("s", "A");
        actual.add("t", "A");
        actual.add("u", "A");
        actual.add("v", "A");
        actual.add("w", "A");
        actual.add("x", "A");
        actual.add("y", "A");
        actual.add("z", "A");
        actual.add("a1", "A");
        actual.add("b1", "A");
        actual.add("c1", "A");
        actual.add("d1", "A");
        actual.add("e1", "A");
        actual.add("f1", "A");
        actual.add("g1", "A");
        actual.add("h1", "A");
        actual.add("i1", "A");
        actual.add("j1", "A");
        actual.add("k1", "A");
        actual.add("l1", "A");
        actual.add("m1", "A");
        actual.add("n1", "A");
        actual.add("o1", "A");
        actual.add("p1", "A");
        actual.add("q1", "A");
        actual.add("r1", "A");
        actual.add("s1", "A");
        actual.add("t1", "A");
        actual.add("u1", "A");
        actual.add("v1", "A");
        actual.add("w1", "A");
        actual.add("x1", "A");
        actual.add("y1", "A");
        actual.add("z1", "A");
        actual.remove("v1");

    }

    private static void testAdd() {
        AssociativeArray<String, String> expected = new AssociativeArray<>();
        expected.add("a", "A");
        expected.add("b", "A");
        expected.add("c", "A");
        expected.add("d", "A");
        expected.add("e", "A");
        expected.add("f", "A");
        expected.add("g", "A");
        expected.add("h", "A");
        expected.add("i", "A");
        expected.add(null, "5");
        AssociativeArray<String, String> actual = new AssociativeArray<>();
        actual.add("a", "A");
        actual.add("b", "A");
        actual.add("c", "A");
        actual.add("d", "A");
        actual.add("e", "A");
        actual.add("f", "A");
        actual.add("g", "A");
        actual.add("h", "A");
        actual.add("i", "A");
        actual.add(null, "5");
        assertEquals("AssociativeArrayTest.testAdd", expected, actual);
    }

    private static void testGet() {
        AssociativeArray<String, String> expected = new AssociativeArray<>();
        expected.add(null, "5");
        expected.add("m", "A");
        expected.add("n", "A");
        expected.add("o", "A");
        expected.add("p", "A");
        expected.add("p", "B");
        expected.add("q", "A");
        expected.add("r", "A");
        expected.add("s", "A");
        expected.add("t", "A");
        AssociativeArray<String, String> actual = new AssociativeArray<>();
        actual.add(null, "5");
        actual.add("m", "A");
        actual.add("n", "A");
        actual.add("o", "A");
        actual.add("p", "B");
        actual.add("q", "A");
        actual.add("r", "A");
        actual.add("s", "A");
        actual.add("t", "A");
        assertEquals("AssociativeArrayTest.testGet", expected.get("p"), actual.get("p"));
    }

    private static void testGetNull() {
        AssociativeArray<String, String> expected = new AssociativeArray<>();
        expected.add(null, "5");
        expected.add("m", "A");
        expected.add("n", "A");
        expected.add("o", "A");
        expected.add("p", "A");
        expected.add("p", "B");
        expected.add("q", "A");
        expected.add("r", "A");
        expected.add("s", "A");
        expected.add("t", "A");
        AssociativeArray<String, String> actual = new AssociativeArray<>();
        actual.add(null, "5");
        actual.add("m", "A");
        actual.add("n", "A");
        actual.add("o", "A");
        actual.add("p", "B");
        actual.add("q", "A");
        actual.add("r", "A");
        actual.add("s", "A");
        actual.add("t", "A");
        assertEquals("AssociativeArrayTest.testGetNull", expected.get(null), actual.get(null));
    }

    private static void testGetException() {
        AssociativeArray<String, String> actual = new AssociativeArray<>(20);
        actual.add("a", "A");
        actual.add("b", "A");
        actual.add("c", "A");
        actual.add("d", "A");
        actual.add("e", "A");
        actual.add("f", "A");
        actual.add("g", "A");
        actual.add("h", "A");
        try {
            actual.get("z");
            fail("AssociativeArrayTest.testGetException");
        } catch (NoSuchElementException e) {
            assertEquals("AssociativeArrayTest.testGetException", "There is no element with key: z", e.getMessage());
        }
    }

    private static void testRemove() {
        AssociativeArray<String, String> expected = new AssociativeArray<>();
        expected.add("a", "A");
        expected.add("b", "A");
        expected.add("c", "A");
        expected.add("d", "A");
        expected.add("e", "A");
        expected.add(null, "5");
        expected.add("n", "A");
        expected.add("v", "A");
        expected.add("w", "A");
        expected.add("x", "A");
        expected.add("y", "A");
        expected.add("z", "A");
        AssociativeArray<String, String> actual = new AssociativeArray<>();
        actual.add("a", "A");
        actual.add("b", "A");
        actual.add("c", "A");
        actual.add("d", "A");
        actual.add("e", "A");
        actual.add(null, "5");
        actual.add("m", "A");
        actual.add("m", "B");
        actual.add("n", "A");
        actual.add("v", "A");
        actual.add("w", "A");
        actual.add("x", "A");
        actual.add("y", "A");
        actual.add("z", "A");
        actual.remove("m");
        assertEquals("AssociativeArrayTest.testRemove", expected, actual);
    }

    private static void testRemoveNull() {
        AssociativeArray<String, String> expected = new AssociativeArray<>();
        expected.add("a", "A");
        expected.add("b", "A");
        expected.add("c", "A");
        expected.add("d", "A");
        expected.add("e", "A");
        expected.add("m", "A");
        expected.add("n", "A");
        expected.add("v", "A");
        expected.add("w", "A");
        expected.add("x", "A");
        expected.add("y", "A");
        expected.add("z", "A");
        AssociativeArray<String, String> actual = new AssociativeArray<>();
        actual.add("a", "A");
        actual.add("b", "A");
        actual.add("c", "A");
        actual.add("d", "A");
        actual.add("e", "A");
        actual.add(null, "5");
        actual.add("m", "A");
        actual.add("n", "A");
        actual.add("v", "A");
        actual.add("w", "A");
        actual.add("x", "A");
        actual.add(null, "&");
        actual.add("y", "A");
        actual.add("z", "A");
        actual.remove(null);
        assertEquals("AssociativeArrayTest.testRemoveNull", expected, actual);
    }

    private static void testPolygenlubricants() {
        try {
            AssociativeArray<String, String> actual = new AssociativeArray<>(15);
            actual.add("accismus toddlertoddy", "A");
            actual.add("acephalisthematolysis", "A");
            actual.add("acousmatic gymnarchidaegymnarchus", "A");
            actual.add("ACETOMORPHINE ACHENE", "A");
            actual.add("ALVEOLODENTAL WALDENSES", "A");
            actual.add("APODAN UNCONTENDED", "A");
            actual.add("auraadmonitorial", "A");
            actual.add("BALSAMROOT SQUARENESS", "A");
            actual.add("actuation conjugant", "A");
            actual.add("accompt hypercriticism", "A");
            actual.add("acetothienoneruledom", "A");
            actual.add("achroite unenviablyunenvied", "A");
            actual.add("adventitiouslyoniscoidea", "A");
            actual.add("AFFORCEMISBAPTIZE", "A");
            actual.add("aggressquadrifurcate", "A");
            actual.add("bamboozlercastaway", "A");
            actual.add("ABASEDNESS RESEMBLANCERESEMBLANT", "A");
            actual.add("actuation conjugant", "A");
            actual.add("addlepate Burushaski", "A");
            actual.add("AIRCREWBRUTALIZATION", "A");
            actual.add("ANALYZATIONDIANCECHT", "A");
            actual.add("andrewsite sruti", "A");
            actual.add("apatetic libber", "A");
            actual.add("attached retranslate", "A");
            actual.get("achroite unenviablyunenvied");
            actual.get("attached retranslate");
            actual.get("acephalisthematolysis");
            actual.remove("achroite unenviablyunenvied");
            actual.remove("attached retranslate");
            actual.remove("acephalisthematolysis");
            System.out.println("AssociativeArrayTest.testPolygenlubricants: passed");
        } catch (Exception e) {
            System.out.println("AssociativeArrayTest.testPolygenlubricants: failed");
        }


    }
}
