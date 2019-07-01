/**
 * @Description: 二叉树查找指定节点
 * @Author: qizhi.wang
 * @Date: 2019/6/27
 *
 *          1
 *         / \
 *        2  3
 *         /  \
 *        5    4
 *
 *  前序查找思路：
 *     1.先判断当前节点的no是否等于需要查找的值
 *     2.如果是相等，则返回当前节点
 *     3.如果不等，则判断当前节点的左节点是否为空，如果不为空，则递归前序查找
 *     4.如果左递归前序查找，找到节点，则返回，否则继续判断，当前的节点的右子
 *       节点是否为空，如果不空，则继续向右递归前序查找
 *
 */
public class BinaryTreeDemo2 {
    public static void main(String[] args) {
        //创建二叉树
        BinaryTree2 binaryTree2 = new BinaryTree2();
        //创建节点
        HeroNode2 root = new HeroNode2(1, "aaa");
        HeroNode2 heroNode2 = new HeroNode2(2, "bbb");
        HeroNode2 heroNode3 = new HeroNode2(3, "ccc");
        HeroNode2 heroNode4 = new HeroNode2(4, "ddd");
        HeroNode2 heroNode5 = new HeroNode2(5, "eee");
        //二叉树应该为递归创建
        root.setLeft(heroNode2);
        root.setRight(heroNode3);
        heroNode3.setRight(heroNode4);
        heroNode3.setLeft(heroNode5);
        binaryTree2.setRoot(root);
        //测试前序遍历
//        System.out.println("前序遍历:");
//        binaryTree2.preOrder();
//        System.out.println("中序遍历:");
//        binaryTree2.midOrder();
//        System.out.println("后序遍历：");
//        binaryTree2.postOrder();

        //使用前序遍历查询
        System.out.println(binaryTree2.preOrderSearch(2));


    }

}

//定义二叉树
class BinaryTree2 {
    private HeroNode2 root;

    public void setRoot(HeroNode2 root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历。。。");
        }
    }

    //中序遍历
    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder();
        } else {
            System.out.println("二叉树为空，无法遍历。。。");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历。。。");
        }
    }

    //前序遍历查询
    public  HeroNode2 preOrderSearch(int no){
        if (root!=null){
            return root.findNodeWithPre(no);
        }else{
            return null;
        }
    }
}
//HeroNode节点
class HeroNode2 {
    private int      no;
    private String   name;
    private HeroNode2 left;
    private HeroNode2 right;

    public HeroNode2(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode2 getLeft() {
        return left;
    }

    public void setLeft(HeroNode2 left) {
        this.left = left;
    }

    public HeroNode2 getRight() {
        return right;
    }

    public void setRight(HeroNode2 right) {
        this.right = right;
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        //递归左子树
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void midOrder() {
        //递归左子树中序遍历
        if (this.left != null) {
            this.left.midOrder();
        }
        //输出父节点
        System.out.println(this);
        //递归向右子树中序遍历
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        //递归左子树后序遍历
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归向右子树后序遍历
        if (this.right != null) {
            this.right.postOrder();
        }
        //输出父节点
        System.out.println(this);
    }

    public HeroNode2 findNodeWithPre(int no) {
        if (no== this.no) {
            return this;
        }
        HeroNode2 temp1 =null;
        if(this.getLeft()!=null){
            temp1 =  this.left.findNodeWithPre(no);
        }
        if(temp1!=null){
            return temp1;
        }

        if(this.getRight()!=null){
            temp1 =  this.right.findNodeWithPre(no);
        }
        if(temp1!=null){
            return temp1;
        }

        return null;
    }
}
