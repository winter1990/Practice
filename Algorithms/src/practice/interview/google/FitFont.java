package practice.interview.google;

public class FitFont {
    public int maxFintSize(String s, int width, int height, int min, int max) {
        int res = -1;
        int size = min;
        for (; size <= max; size++) {
            if (canFit(s, width, height, size)) {
                res = size;
            }
        }
        return res;
    }

    private boolean canFit(String s, int width, int height, int fontSize) {
        int i;
        int index = 0;
        int h = heightOf(fontSize);
        for (i = 0; i < s.length(); i++) {
            if (h > height) {
                return false;
            }
            int w = widthOf(fontSize, s.charAt(i));
            if (index + w > width) {
                index = 0;
                height -= h;
                i -= 1;
                continue;
            }
            index += w;
        }
        if (i == s.length()) {
            return true;
        }
        return false;
    }

    int widthOf(int fontSize, char c) {
        return fontSize;
    }
    int heightOf(int fontSize) {
        return fontSize;
    }

    public static void main(String[] args) {
        FitFont ff = new FitFont();
        int height = 6;
        int width = 13;
        String s = "abcdefgh";
        System.out.println(ff.maxFintSize(s, width, height, 1, 5));
    }
}
