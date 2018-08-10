package jEfStructure;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class JEfQuadTreeTest {

    private JEfQuadTree JEfQuadTree;

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void testDefaultConstructor()
    {
        JEfQuadTree = new JEfQuadTree();
        assertEquals(Integer.valueOf(0), JEfQuadTree.getLevel());
        assertEquals(Integer.valueOf(0), JEfQuadTree.getX());
        assertEquals(Integer.valueOf(0), JEfQuadTree.getY());
        assertEquals(Integer.valueOf(100), JEfQuadTree.getW());
        assertEquals(Integer.valueOf(100), JEfQuadTree.getH());
        assertArrayEquals(new JEfQuadTree[4], JEfQuadTree.getChildren());
        assertEquals(0, JEfQuadTree.getJEfRectangleObjects().size());
    }

    @Test
    public void testConstructorWithParams(){
        JEfQuadTree = new JEfQuadTree(2,4,1, 2, 3, 4, 5, null);
        assertEquals(2, JEfQuadTree.getMaxObjects());
        assertEquals(4, JEfQuadTree.getMaxLevels());
        assertEquals(Integer.valueOf(1), JEfQuadTree.getLevel());
        assertEquals(Integer.valueOf(2), JEfQuadTree.getX());
        assertEquals(Integer.valueOf(3), JEfQuadTree.getY());
        assertEquals(Integer.valueOf(4), JEfQuadTree.getW());
        assertEquals(Integer.valueOf(5), JEfQuadTree.getH());
        assertArrayEquals(new JEfQuadTree[4], JEfQuadTree.getChildren());
        assertEquals(0, JEfQuadTree.getJEfRectangleObjects().size());
    }

    @Test
    public void testInsertAnItem(){
        JEfQuadTree = new JEfQuadTree();
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf());
        assertEquals(Integer.valueOf(1), Integer.valueOf(JEfQuadTree.getJEfRectangleObjects().size()));

        //children are still null
        assertNull(JEfQuadTree.getChildren()[JEfQuadTree.NE_CHILD]);
        assertNull(JEfQuadTree.getChildren()[JEfQuadTree.NW_CHILD]);
        assertNull(JEfQuadTree.getChildren()[JEfQuadTree.SW_CHILD]);
        assertNull(JEfQuadTree.getChildren()[JEfQuadTree.SE_CHILD]);
    }

    @Test
    public void testInsertMultipleItems(){
        JEfQuadTree = new JEfQuadTree();

        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf());
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf());
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf());
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf());
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf());

        //5 items in tree
        assertEquals(Integer.valueOf(5), Integer.valueOf(JEfQuadTree.getJEfRectangleObjects().size()));

        //children are still null
        assertNull(JEfQuadTree.getChildren()[JEfQuadTree.NE_CHILD]);
        assertNull(JEfQuadTree.getChildren()[JEfQuadTree.NW_CHILD]);
        assertNull(JEfQuadTree.getChildren()[JEfQuadTree.SW_CHILD]);
        assertNull(JEfQuadTree.getChildren()[JEfQuadTree.SE_CHILD]);
    }

    @Test
    public void testInsertWithSplitIntoEachChild(){
        JEfQuadTree = new JEfQuadTree();

        //only store 2 objects per node
        JEfQuadTree.setMaxObjects(2);

        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(1.0,1.0,1.0,1.0));
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(51.0,51.0,1.0,1.0));

        //no split has happened yet
        assertEquals(Integer.valueOf(2), Integer.valueOf(JEfQuadTree.getJEfRectangleObjects().size()));

        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(51.0,1.0,1.0,1.0));

        //split happened, root should not hold any objects
        assertEquals(Integer.valueOf(0), Integer.valueOf(JEfQuadTree.getJEfRectangleObjects().size()));

        //NW quadrant has 1 object, SE quadrant also has one object, NE has one object, SW still has 0
        assertEquals(Integer.valueOf(1), Integer.valueOf(JEfQuadTree.getChildren()[JEfQuadTree.NW_CHILD].getJEfRectangleObjects().size()));
        assertEquals(Integer.valueOf(1), Integer.valueOf(JEfQuadTree.getChildren()[JEfQuadTree.SE_CHILD].getJEfRectangleObjects().size()));
        assertEquals(Integer.valueOf(1), Integer.valueOf(JEfQuadTree.getChildren()[JEfQuadTree.NE_CHILD].getJEfRectangleObjects().size()));
        assertEquals(Integer.valueOf(0), Integer.valueOf(JEfQuadTree.getChildren()[JEfQuadTree.SW_CHILD].getJEfRectangleObjects().size()));

        //insert one that should go to SW
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(1.0,51.0,1.0,1.0));
        assertEquals(Integer.valueOf(1), Integer.valueOf(JEfQuadTree.getChildren()[JEfQuadTree.SW_CHILD].getJEfRectangleObjects().size()));
    }

    //TODO: bad practice to use anything random in unit tests (or is it good practice?)
    public void testCountTotalObjects(){

        JEfQuadTree = new JEfQuadTree();
        //insert 10 objects
        for(int i = 0; i < 10; i++){
            JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(Math.random() * 100, Math.random() * 100, 1.0, 1.0));
        }
        assertEquals(Integer.valueOf(10), JEfQuadTree.getTotalObjects());

        for(int i = 0; i < 5; i++){
            JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(Math.random() * 100, Math.random() * 100, 1.0, 1.0));
        }

        assertEquals(Integer.valueOf(15), JEfQuadTree.getTotalObjects());

    }


    @Test
    public void testGetDepth(){
        JEfQuadTree = new JEfQuadTree();
        JEfQuadTree.setMaxObjects(2);

        //insert one object into NW
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(0.0,0.0,1.0,1.0));

        assertEquals(Integer.valueOf(1), JEfQuadTree.getDepth());

        //insert another object SE
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(51.0,51.0,1.0,1.0));
        assertEquals(Integer.valueOf(1), JEfQuadTree.getDepth());

        //insert a 3rd object into NE
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(51.0,0.0,1.0,1.0));
        assertEquals(Integer.valueOf(2), JEfQuadTree.getDepth());

        //now lets add a few more into the NW
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(26.0,26.0,1.0,1.0));
        assertEquals(Integer.valueOf(2), JEfQuadTree.getDepth());

        //another split occurs on this insert
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(26.0,0.0,1.0,1.0));
        assertEquals(Integer.valueOf(3), JEfQuadTree.getDepth());

    }

    @Test
    public void testClearQuadTree(){
        JEfQuadTree = new JEfQuadTree();
        //insert 10 objects
        for(int i = 0; i < 10; i++){
            JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(Math.random() * 100, Math.random() * 100, 1.0, 1.0));
        }
        assertEquals(Integer.valueOf(10), JEfQuadTree.getTotalObjects());

        JEfQuadTree.clear();

        assertEquals(Integer.valueOf(0), JEfQuadTree.getTotalObjects());
        assertNull(JEfQuadTree.getChildren()[JEfQuadTree.NE_CHILD]);
        assertNull(JEfQuadTree.getChildren()[JEfQuadTree.NW_CHILD]);
        assertNull(JEfQuadTree.getChildren()[JEfQuadTree.SW_CHILD]);
        assertNull(JEfQuadTree.getChildren()[JEfQuadTree.SE_CHILD]);

    }

    @Test
    public void testSearch(){
        JEfQuadTree = new JEfQuadTree();
        JEfQuadTree.setMaxObjects(2);

        List<JEfRectangleObject> results;
        //search entire empty quadtree
        results = JEfQuadTree.search(new JEfSearchJEfRectangleObjectJEf(0.0, 0.0, 100.0, 100.0));

        assertNotNull(results);
        assertEquals(0, results.size());


        //insert one object into the quadtree
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(0.0, 0.0, 1.0, 1.0));

        //search the entire quadtree
        results = JEfQuadTree.search(new JEfSearchJEfRectangleObjectJEf(0.0, 0.0, 100.0, 100.0));
        assertEquals(1, results.size());

        //do a search that misses the item
        results = JEfQuadTree.search(new JEfSearchJEfRectangleObjectJEf(5.0, 5.0, 95.0, 95.0));
        assertEquals(0, results.size());


        //do an exact bounds search
        results = JEfQuadTree.search(new JEfSearchJEfRectangleObjectJEf(0.0, 0.0, 1.0, 1.0));
        assertEquals(1, results.size());

        //add a few more items in the quadtree
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(51.0, 51.0, 1.0, 1.0));
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(51.0, 0.0, 1.0, 1.0));

        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(26.0, 26.0, 1.0, 1.0));
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(26.0, 0.0, 1.0, 1.0));
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(28.0, 28.0, 1.0, 1.0));

        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(24.0, 24.0, 4.0, 4.0));

        //search entire quadtree again, make sure everything is found
        results = JEfQuadTree.search(new JEfSearchJEfRectangleObjectJEf(0.0, 0.0, 100.0, 100.0));
        assertEquals(7, results.size());

        //search in exact quadtree boundary
        results = JEfQuadTree.search(new JEfSearchJEfRectangleObjectJEf(50.0, 50.0, 50.0, 50.0));
        assertEquals(1, results.size());

        //search overlapping boundaries
        results = JEfQuadTree.search(new JEfSearchJEfRectangleObjectJEf(50.0, 0.0, 50.0, 100.0));
        assertEquals(2, results.size());

        //search overlapping an object
        results = JEfQuadTree.search(new JEfSearchJEfRectangleObjectJEf(25.0, 25.0, 25.0, 25.0));
        assertEquals(3, results.size());

        //search with no result fully in search area
        results = JEfQuadTree.search(new JEfSearchJEfRectangleObjectJEf(0.0, 25.0, 25.0, 25.0));
        assertEquals(1, results.size());

        //search spanning multiple areas and different levels of the quadtree
        results = JEfQuadTree.search(new JEfSearchJEfRectangleObjectJEf(0.0, 0.0, 50.0, 50.0));
        assertEquals(5, results.size());


        //test search area fits perfectly in child of quadtree that has the item it should hit
        results = JEfQuadTree.search(new JEfSearchJEfRectangleObjectJEf(23.0, 23.0, 1.5, 1.5));
        assertEquals(1, results.size());

        //test where search area is along the border of an object in the quadtree
        results = JEfQuadTree.search(new JEfSearchJEfRectangleObjectJEf(27.0, 26.0 , 1.0, 1.0));
        assertEquals(2, results.size());

        //test where search area is along the border of 2 objects in different levels of the quadtree
        results = JEfQuadTree.search(new JEfSearchJEfRectangleObjectJEf(1.0, 0.0, 23.0, 30.0));
        assertEquals(2, results.size());

        //test where search area is along the border of 2 objects in the same level of the quadtree
        results = JEfQuadTree.search(new JEfSearchJEfRectangleObjectJEf(27.0, 27.0, 1.0, 1.0));
        assertEquals(3, results.size());
    }


    @Test
    public void testRemove(){
        JEfQuadTree = new JEfQuadTree();
        JEfQuadTree.setMaxObjects(2);

        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(0.0, 0.0, 1.0, 1.0, "1"));
        //add a few more items in the quadtree
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(51.0, 51.0, 1.0, 1.0, "2"));
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(51.0, 0.0, 1.0, 1.0, "3"));

        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(26.0, 26.0, 1.0, 1.0, "4"));
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(26.0, 0.0, 1.0, 1.0, "5"));
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(28.0, 28.0, 1.0, 1.0, "6"));

        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(24.0, 24.0, 4.0, 4.0, "7"));

        assertEquals(Integer.valueOf(3), JEfQuadTree.getDepth());
        assertEquals(Integer.valueOf(7), JEfQuadTree.getTotalObjects());


        //remove an object that is in the quadtree
        JEfRectangleObject JEfRectangleObject = JEfQuadTree.remove(new JEfSearchJEfRectangleObjectJEf(0.0, 0.0, 1.0, 1.0, "1"));
        assertEquals(Double.valueOf(0.0), JEfRectangleObject.getX());
        assertEquals(Double.valueOf(0.0), JEfRectangleObject.getY());
        assertEquals(Double.valueOf(1.0), JEfRectangleObject.getW());
        assertEquals(Double.valueOf(1.0), JEfRectangleObject.getH());
        assertEquals("1", JEfRectangleObject.getId());

        assertEquals(Integer.valueOf(6), JEfQuadTree.getTotalObjects());

        //remove an object that is not in the quadtree
        JEfRectangleObject = JEfQuadTree.remove(new JEfSearchJEfRectangleObjectJEf(0.0, 0.0, 1.0, 1.0, "1"));
        assertNull(JEfRectangleObject);

        //remove an object that is over a boundary
        JEfRectangleObject = JEfQuadTree.remove(new JEfSearchJEfRectangleObjectJEf(24.0, 24.0, 4.0, 4.0, "7"));
        assertEquals(Double.valueOf(24.0), JEfRectangleObject.getX());
        assertEquals(Double.valueOf(24.0), JEfRectangleObject.getY());
        assertEquals(Double.valueOf(4.0), JEfRectangleObject.getW());
        assertEquals(Double.valueOf(4.0), JEfRectangleObject.getH());
        assertEquals("7", JEfRectangleObject.getId());

        //remove the rest of the objects

        JEfQuadTree.remove(new JEfSearchJEfRectangleObjectJEf(51.0, 51.0, 1.0, 1.0, "2"));
        JEfQuadTree.remove(new JEfSearchJEfRectangleObjectJEf(51.0, 0.0, 1.0, 1.0, "3"));
        JEfQuadTree.remove(new JEfSearchJEfRectangleObjectJEf(26.0, 26.0, 1.0, 1.0, "4"));
        JEfQuadTree.remove(new JEfSearchJEfRectangleObjectJEf(26.0, 0.0, 1.0, 1.0, "5"));
        JEfQuadTree.remove(new JEfSearchJEfRectangleObjectJEf(28.0, 28.0, 1.0, 1.0, "6"));

        //verify that the quadtree is empty
        assertEquals(Integer.valueOf(0), JEfQuadTree.getTotalObjects());

        //verify that the quadtree still has the original depth
        assertEquals(Integer.valueOf(3), JEfQuadTree.getDepth());

    }

    @Test
    public void testUpdate(){
        //going to set up the same quadtree I have been using
        JEfQuadTree = new JEfQuadTree();
        JEfQuadTree.setMaxObjects(2);

        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(0.0, 0.0, 1.0, 1.0, "1"));
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(51.0, 51.0, 1.0, 1.0, "2"));
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(51.0, 0.0, 1.0, 1.0, "3"));
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(26.0, 26.0, 1.0, 1.0, "4"));
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(26.0, 0.0, 1.0, 1.0, "5"));
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(28.0, 28.0, 1.0, 1.0, "6"));
        JEfQuadTree.insert(new JEfSearchJEfRectangleObjectJEf(24.0, 24.0, 4.0, 4.0, "7"));

        //test updating non-existing item in JEfQuadTree, make sure no items were added
        JEfQuadTree.update(new JEfSearchJEfRectangleObjectJEf(5.0, 5.0, 5.0, 5.0, "test"), new JEfSearchJEfRectangleObjectJEf(25.0, 35.0, 5.0, 5.0));
        assertEquals(Integer.valueOf(7), JEfQuadTree.getTotalObjects());
        assertEquals(0, JEfQuadTree.search(new JEfSearchJEfRectangleObjectJEf(5.0, 5.0, 5.0, 5.0, "test")).size());
        assertEquals(0, JEfQuadTree.search(new JEfSearchJEfRectangleObjectJEf(25.0, 35.0, 5.0, 5.0, "test")).size());


        //test moving item out of quadtree
        JEfQuadTree.update(new JEfSearchJEfRectangleObjectJEf(28.0, 28.0, 1.0, 1.0, "6"), new JEfSearchJEfRectangleObjectJEf(100.0, 100.0, 1.0, 1.0, "6"));
        assertEquals(Integer.valueOf(6), JEfQuadTree.getTotalObjects());

        //test moving item to outside border of quadtree
        JEfQuadTree.update(new JEfSearchJEfRectangleObjectJEf(26.0, 26.0, 1.0, 1.0, "4"), new JEfSearchJEfRectangleObjectJEf(-.5, 0.5, 1.0, 1.0, "4"));
        assertEquals(Integer.valueOf(5), JEfQuadTree.getTotalObjects());


        //test move object without crossing JEfQuadTree boundaries
        JEfQuadTree.update(new JEfSearchJEfRectangleObjectJEf(0.0, 0.0, 1.0, 1.0, "1"), new JEfSearchJEfRectangleObjectJEf(1.0, 1.0, 1.0, 1.0, "1"));

        List<JEfRectangleObject> results = JEfQuadTree.getChildren()[JEfQuadTree.NW_CHILD].getChildren()[JEfQuadTree.NW_CHILD].getJEfRectangleObjects();
        assertEquals(1, results.size());
        JEfRectangleObject JEfRectangleObject = results.get(0);
        assertEquals(Double.valueOf(1.0), JEfRectangleObject.getX());
        assertEquals(Double.valueOf(1.0), JEfRectangleObject.getY());
        assertEquals(Double.valueOf(1.0), JEfRectangleObject.getW());
        assertEquals(Double.valueOf(1.0), JEfRectangleObject.getH());
        assertEquals("1", JEfRectangleObject.getId());

        //test move object across boundary back to root JEfQuadTree
        JEfQuadTree.update(new JEfSearchJEfRectangleObjectJEf(26.0, 0.0, 1.0, 1.0, "5"), new JEfSearchJEfRectangleObjectJEf(51.0, 5.0, 1.0, 1.0, "5"));
        results = JEfQuadTree.getChildren()[JEfQuadTree.NE_CHILD].getJEfRectangleObjects();
        assertEquals(2, results.size());

        //test moving object where it should go to a subtree
        JEfQuadTree.update(new JEfSearchJEfRectangleObjectJEf(24.0, 24.0, 4.0, 4.0, "7"), new JEfSearchJEfRectangleObjectJEf(2.0, 30.0, 4.0, 4.0, "7"));
        results = JEfQuadTree.getChildren()[JEfQuadTree.NW_CHILD].getChildren()[JEfQuadTree.SW_CHILD].getJEfRectangleObjects();
        assertEquals(1, results.size());
        JEfRectangleObject = results.get(0);
        assertEquals(Double.valueOf(2.0), JEfRectangleObject.getX());
        assertEquals(Double.valueOf(30.0), JEfRectangleObject.getY());
        assertEquals(Double.valueOf(4.0), JEfRectangleObject.getW());
        assertEquals(Double.valueOf(4.0), JEfRectangleObject.getH());

        //test moving object onto border of JEfQuadTree
        results = JEfQuadTree.getJEfRectangleObjects();
        assertEquals(0, results.size());
        JEfQuadTree.update(new JEfSearchJEfRectangleObjectJEf(2.0, 30.0, 4.0, 4.0, "7"), new JEfSearchJEfRectangleObjectJEf(2.0, 48.0, 4.0, 4.0, "7"));
        results = JEfQuadTree.getJEfRectangleObjects();
        assertEquals(1, results.size());
        JEfRectangleObject = results.get(0);
        assertEquals(Double.valueOf(2.0), JEfRectangleObject.getX());
        assertEquals(Double.valueOf(48.0), JEfRectangleObject.getY());
        assertEquals(Double.valueOf(4.0), JEfRectangleObject.getW());
        assertEquals(Double.valueOf(4.0), JEfRectangleObject.getH());
    }

    //TODO should probably just make an inner class to this called MockRectangleObject that will have helpful constructors


}