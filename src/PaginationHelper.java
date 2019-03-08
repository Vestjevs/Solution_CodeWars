import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PaginationHelper<I> {
    private List<I> list;
    private int var;

    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.list = collection;
        this.var = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return list.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        return list.size() % var == 0 ? list.size() / var : list.size() / var + 1;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex >= pageCount()) return -1;
        if (var == 1) return 1;
        return pageIndex == pageCount() - 1 ? list.size() % var : var;

    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        return itemIndex < 0 ? -1 : itemIndex >= list.size() ? -1 : itemIndex / var;
    }

    public static void main(String[] args) {
        PaginationHelper<Integer> helper = new PaginationHelper<>(Arrays.asList(1, 2, 3, 2, 3, 4, 5), 2);
        System.out.println("helper.pageCount() : " + helper.pageCount() +
                "\n" + "helper.itemCount() : " + helper.itemCount() +
                "\n" + "helper.pageItemCount(2) :" + helper.pageItemCount(2) +
                "\n" + "helper.pageIndex(0) : " + helper.pageIndex(7));
//        System.out.println(2 % 3);
    }


}
