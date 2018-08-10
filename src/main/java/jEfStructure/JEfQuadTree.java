package jEfStructure;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class JEfQuadTree {

    protected static final int THIS_QUADTREE = -1;
    protected static final int NE_CHILD = 0;
    protected static final int NW_CHILD = 1;
    protected static final int SW_CHILD = 2;
    protected static final int SE_CHILD = 3;

    //config
    private int maxObjects = 10;
    private int maxLevels = 5;
    private int defaultWidth = 100;
    private int defaultHeight = 100;

    //link to parent
    private JEfQuadTree parent;

    //children
    private JEfQuadTree[] children;

    //objects in node
    private List<JEfRectangleObject> JEfRectangleObjects;

    //how deep this JEfQuadTree is
    private Integer level;

    //bounds
    private Integer x;
    private Integer y;
    private Integer w;
    private Integer h;

    //create a JEfQuadTree with no parent, intended for creating root node
    public JEfQuadTree(){
        this.level = 0;
        this.x = 0;
        this.y = 0;
        this.w = defaultWidth;
        this.h = defaultHeight;
        this.JEfRectangleObjects = new ArrayList<>();
        this.parent = null;
        this.children = new JEfQuadTree[4];
    }

    public JEfQuadTree(int maxObjects, int maxLevels, int level, int x, int y, int w, int h, JEfQuadTree parent){
        this.maxObjects = maxObjects;
        this.maxLevels = maxLevels;
        this.level = level;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.JEfRectangleObjects = new ArrayList<>();
        this.parent = parent;
        this.children = new JEfQuadTree[4];
    }

    public void insert(JEfRectangleObject JEfRectangleObject){
        //if this JEfQuadTree has children (only need to check the first one to be sure of that)
        if(children[0] != null){
            int indexToPlaceObject = getChildIndexRectangleBelongsIn(JEfRectangleObject);

            //if it doesn't belong on this JEfQuadTree, let one of the children find where to put it
            if(indexToPlaceObject != JEfQuadTree.THIS_QUADTREE){
                children[indexToPlaceObject].insert(JEfRectangleObject);
                return;
            }
        }
        //add the object to the list for this JEfQuadTree
        JEfRectangleObjects.add(JEfRectangleObject);

        //if we need to split up this JEfQuadTree
        if(JEfRectangleObjects.size() > this.maxObjects && this.level < this.maxLevels) {
            //code I am stealing had a check right here, which I think is unnecessary
            split();

            //just split JEfQuadTree, lets put the objects that are on this JEfQuadTree where they belong
            int i = 0;
            while (i < JEfRectangleObjects.size()) {
                int indexToPlaceObject = getChildIndexRectangleBelongsIn(JEfRectangleObjects.get(i));
                //if the object does not belong on this JEfQuadTree
                if (indexToPlaceObject != JEfQuadTree.THIS_QUADTREE) {
                    //if we remove an object don't increment i, the next object bumps down to where i is
                    children[indexToPlaceObject].insert(JEfRectangleObjects.remove(i));
                } else {
                    i++;
                }
            }
        }
    }

    //probably should add a re-balance function to quadtrees where it takes all its kids and re-inserts them
    public JEfRectangleObject remove(JEfRectangleObject JEfRectangleObject){
        int index = getChildIndexRectangleBelongsIn(JEfRectangleObject);
        if(index == JEfQuadTree.THIS_QUADTREE || this.children[index] == null){
            for(int i = 0; i < this.JEfRectangleObjects.size(); i++){
                if(JEfRectangleObjects.get(i).getId().equals(JEfRectangleObject.getId())){
                    return JEfRectangleObjects.remove(i);
                }
            }
        }else{
            return this.children[index].remove(JEfRectangleObject);
        }

        return null;
    }

    public void update(JEfRectangleObject initialJEfRectangleObject, JEfRectangleObject updatedJEfRectangleObject){

        //start with root
        JEfQuadTree JEfQuadTree = this;
        int index = JEfQuadTree.getChildIndexRectangleBelongsIn(initialJEfRectangleObject);

        //travel down the JEfQuadTree until I am where the item could potentially be
        while(index != JEfQuadTree.THIS_QUADTREE && JEfQuadTree.children[index] != null){
            JEfQuadTree = JEfQuadTree.children[index];
            index = JEfQuadTree.getChildIndexRectangleBelongsIn(initialJEfRectangleObject);
        }

        //loop through items on JEfQuadTree and see if we can find the one we are updating
        //there is a bug here! What happens if there are two items in the JEfQuadTree and we update the first one and it remains on the JEfQuadTree, I thin our update code will run twice!
        for(int i = 0; i < JEfQuadTree.getJEfRectangleObjects().size(); i++){
            if(JEfQuadTree.getJEfRectangleObjects().get(i).getId().equals(initialJEfRectangleObject.getId())){

                //write updated properties on object
                JEfRectangleObject JEfRectangleObjectToUpdate = JEfQuadTree.getJEfRectangleObjects().remove(i);
                JEfRectangleObjectToUpdate.setX(updatedJEfRectangleObject.getX());
                JEfRectangleObjectToUpdate.setY(updatedJEfRectangleObject.getY());
                JEfRectangleObjectToUpdate.setW(updatedJEfRectangleObject.getW());
                JEfRectangleObjectToUpdate.setH(updatedJEfRectangleObject.getH());

                //if the updated properties still lie in this quadtree, just add the object to the list
                if(JEfGeometryUtil.rectangleObjectIsInside(new JEfSearchJEfRectangleObjectJEf(Double.valueOf(JEfQuadTree.getX()), Double.valueOf(JEfQuadTree.getY()), Double.valueOf(JEfQuadTree.getW()), Double.valueOf(JEfQuadTree.getH())), updatedJEfRectangleObject)){
                    JEfQuadTree.insert(JEfRectangleObjectToUpdate);
                }else{ //start looking back up the quadtree starting with this ones parent
                    JEfQuadTree = JEfQuadTree.getParent();
                    while(JEfQuadTree.getParent() != null && !JEfGeometryUtil.rectangleObjectIsInside(new JEfSearchJEfRectangleObjectJEf(Double.valueOf(JEfQuadTree.getX()), Double.valueOf(JEfQuadTree.getY()), Double.valueOf(JEfQuadTree.getW()), Double.valueOf(JEfQuadTree.getH())), JEfRectangleObjectToUpdate)){
                        JEfQuadTree = JEfQuadTree.getParent();
                    }
                    //only insert if it actually fits in the quadtree I am on
                    if(JEfGeometryUtil.rectangleObjectIsInside(new JEfSearchJEfRectangleObjectJEf(Double.valueOf(JEfQuadTree.getX()), Double.valueOf(JEfQuadTree.getY()), Double.valueOf(JEfQuadTree.getW()), Double.valueOf(JEfQuadTree.getH())), JEfRectangleObjectToUpdate)){
                        JEfQuadTree.insert(JEfRectangleObjectToUpdate);
                    }

                }
                //will never be updating more than one, so top going through the list once we find a match
                break;
            }
        }
    }

    public List<JEfRectangleObject> search(JEfRectangleObject JEfRectangleObject){

        List<JEfRectangleObject> returnList = new ArrayList<>();
        //here I will need to filter through these and only return the objects that are in the search area (even if they are partially in the search area)
        ListIterator<JEfRectangleObject> iterator = search(new ArrayList<JEfRectangleObject>(), JEfRectangleObject).listIterator();
        while(iterator.hasNext()){
            JEfRectangleObject currentJEfRectangleObject = iterator.next();
            if(JEfGeometryUtil.rectangleObjectsOverlap(currentJEfRectangleObject, JEfRectangleObject)){
                returnList.add(currentJEfRectangleObject);
            }
        }
        return returnList;
    }

    public Integer getDepth(){
        return 1 + Math.max(
                Math.max(this.children[JEfQuadTree.NE_CHILD] == null ? 0 : this.children[JEfQuadTree.NE_CHILD].getDepth(), this.children[JEfQuadTree.NW_CHILD] == null ? 0 : this.children[JEfQuadTree.NW_CHILD].getDepth()),
                Math.max(this.children[JEfQuadTree.SW_CHILD] == null ? 0 : this.children[JEfQuadTree.SW_CHILD].getDepth(), this.children[JEfQuadTree.SE_CHILD] == null ? 0 : this.children[JEfQuadTree.SE_CHILD].getDepth())
        );
    }

    public Integer getTotalObjects(){
        return this.JEfRectangleObjects.size() +
                (this.children[JEfQuadTree.NE_CHILD] == null ? 0 : this.children[JEfQuadTree.NE_CHILD].getTotalObjects()) +
                (this.children[JEfQuadTree.NW_CHILD] == null ? 0 : this.children[JEfQuadTree.NW_CHILD].getTotalObjects()) +
                (this.children[JEfQuadTree.SW_CHILD] == null ? 0 : this.children[JEfQuadTree.SW_CHILD].getTotalObjects()) +
                (this.children[JEfQuadTree.SE_CHILD] == null ? 0 : this.children[JEfQuadTree.SE_CHILD].getTotalObjects());
    }

    //recursively remove this quadtree's children
    public void clear(){
        this.JEfRectangleObjects.clear();
        for(int i = 0; i < children.length; i++){
            if(children[i] != null){
                children[i].clear();
                children[i] = null;
            }
        }
    }

    private List<JEfRectangleObject> search(List<JEfRectangleObject> JEfRectangleObjects, JEfRectangleObject JEfRectangleObject){

        JEfRectangleObjects.addAll(this.JEfRectangleObjects);

        int index = getChildIndexRectangleBelongsIn(JEfRectangleObject);
        //if the search area does not fit into any of the children perfectly
        if(index == JEfQuadTree.THIS_QUADTREE || this.children[0] == null){
            //add anything that is on this JEfQuadTree, may need to recurse down and add more
            if(this.children[0] != null){
                //for each of the children, if the search area overlaps with the child area, search the child
                for(int i = 0; i < this.children.length; i++){
                    if(JEfGeometryUtil.rectangleObjectsOverlap(new JEfSearchJEfRectangleObjectJEf(Double.valueOf(this.children[i].getX()), Double.valueOf(this.children[i].getY()),Double.valueOf(this.children[i].getW()), Double.valueOf(this.children[i].getH())), JEfRectangleObject)){
                        this.children[i].search(JEfRectangleObjects, JEfRectangleObject);
                    }
                }
            }
        }else if(this.children[index] != null){
            //search area is in one of the children totally, but we still can't exclude the objects on this node, because that search area could include one
            this.children[index].search(JEfRectangleObjects, JEfRectangleObject);
        }
        return JEfRectangleObjects;
    }



    //instantiate the four children
    private void split(){
        int childWidth = this.w / 2;
        int childHeight = this.h / 2;

        children[JEfQuadTree.NE_CHILD] = new JEfQuadTree(this.maxObjects, this.maxLevels,level + 1, this.x + childWidth, this.y, childWidth, childHeight, this);
        children[JEfQuadTree.NW_CHILD] = new JEfQuadTree(this.maxObjects, this.maxLevels,this.level + 1, this.x, this.y, childWidth, childHeight, this);
        children[JEfQuadTree.SW_CHILD] = new JEfQuadTree(this.maxObjects, this.maxLevels,this.level + 1, this.x, this.y + childHeight, childWidth, childHeight, this);
        children[JEfQuadTree.SE_CHILD] = new JEfQuadTree(this.maxObjects, this.maxLevels,this.level + 1, this.x + childWidth, this.y + childHeight, childWidth, childHeight, this);
    }

    protected int getChildIndexRectangleBelongsIn(JEfRectangleObject JEfRectangleObject){
        //-1 means the object does not fit in any of the children, keep it on the parent
        int index = -1;
        double verticalDividingLine = getX() + getW() / 2;
        double horizontalDividingLine = getY() + getH() / 2;

        //its funny, here you might be tempted to think about what happens if it goes over the bounds, but if it did...we wouldn't have gotten this far, it would be on a parent JEfQuadTree!
        boolean fitsCompletelyInNorthHalf = JEfRectangleObject.getY() < horizontalDividingLine && (JEfRectangleObject.getH() + JEfRectangleObject.getY() < horizontalDividingLine);
        boolean fitsCompletelyInSouthHalf = JEfRectangleObject.getY() > horizontalDividingLine;
        boolean fitsCompletelyInWestHalf = JEfRectangleObject.getX() < verticalDividingLine && (JEfRectangleObject.getX() + JEfRectangleObject.getW() < verticalDividingLine);
        boolean fitsCompletelyInEastHalf = JEfRectangleObject.getX() > verticalDividingLine;

        if(fitsCompletelyInEastHalf){
            if(fitsCompletelyInNorthHalf){
                index = JEfQuadTree.NE_CHILD;
            }else if(fitsCompletelyInSouthHalf){
                index = JEfQuadTree.SE_CHILD;
            }
        }else if(fitsCompletelyInWestHalf){
            if(fitsCompletelyInNorthHalf){
                index = JEfQuadTree.NW_CHILD;
            }else if(fitsCompletelyInSouthHalf){
                index = JEfQuadTree.SW_CHILD;
            }
        }
        return index;
    }

    public int getMaxObjects() {
        return maxObjects;
    }

    public void setMaxObjects(int maxObjects) {
        this.maxObjects = maxObjects;
    }

    public int getMaxLevels() {
        return maxLevels;
    }

    public void setMaxLevels(int maxLevels) {
        this.maxLevels = maxLevels;
    }

    public int getDefaultWidth() {
        return defaultWidth;
    }

    public void setDefaultWidth(int defaultWidth) {
        this.defaultWidth = defaultWidth;
    }

    public int getDefaultHeight() {
        return defaultHeight;
    }

    public void setDefaultHeight(int defaultHeight) {
        this.defaultHeight = defaultHeight;
    }

    public List<JEfRectangleObject> getJEfRectangleObjects() {
        return JEfRectangleObjects;
    }

    public void setJEfRectangleObjects(List<JEfRectangleObject> JEfRectangleObjects) {
        this.JEfRectangleObjects = JEfRectangleObjects;
    }

    public void addRectangleObject(JEfRectangleObject JEfRectangleObject) {
        if(this.JEfRectangleObjects == null){
            this.JEfRectangleObjects = new ArrayList<>();
        }
        this.JEfRectangleObjects.add(JEfRectangleObject);
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public Integer getH() {
        return h;
    }

    public void setH(Integer h) {
        this.h = h;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public JEfQuadTree getParent(){
        return this.parent;
    }

    public void setParent(JEfQuadTree parent){
        this.parent = parent;
    }

    public JEfQuadTree[] getChildren() {
        return children;
    }

    public void setChildren(JEfQuadTree[] children) {
        this.children = children;
    }
}