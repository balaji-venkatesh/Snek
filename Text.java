import java.awt.Color;

public class Text extends PixelComponent {

    String text;
    Color color;

    public Text(int x, int y, String text, Color color) {
        this(x, y, 0, text, color);
    }

    public Text(int x, int y, int z, String text, Color color) {
        super(x, y, z);
        this.text = text;
        this.color = color;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public Color[][] getPixels() {

        Color[][] pixels = new Color[text.length() * 4][6];

        for (int c = 0; c < text.length(); c++) {

            String[] code = encoded[text.charAt(c)];

            for (int i = 0; i < 6; i++)
                for (int j = 0; j < 4; j++)
                    if (code[i].charAt(j) == '1')
                        pixels[c * 4 + j][i] = color;
                    //else
                        //pixels[c * 4 + j][i] = new Color(0,0,0,0);
        }

        return pixels;

    }

    private String[][] encoded = { { "0000", "0000", "0000", "0000", "0000", "0000" },
            { "0000", "0000", "0000", "0000", "0000", "0000" }, { "0000", "0000", "0000", "0000", "0000", "0000" },
            { "0000", "0000", "0000", "0000", "0000", "0000" }, { "0000", "0000", "0000", "0000", "0000", "0000" },
            { "0000", "0000", "0000", "0000", "0000", "0000" }, { "0000", "0000", "0000", "0000", "0000", "0000" },
            { "0000", "0000", "0000", "0000", "0000", "0000" }, { "0000", "0000", "0000", "0000", "0000", "0000" },
            { "0000", "0000", "0000", "0000", "0000", "0000" }, { "0000", "0000", "0000", "0000", "0000", "0000" },
            { "0000", "0000", "0000", "0000", "0000", "0000" }, { "0000", "0000", "0000", "0000", "0000", "0000" },
            { "0000", "0000", "0000", "0000", "0000", "0000" }, { "0000", "0000", "0000", "0000", "0000", "0000" },
            { "0000", "0000", "0000", "0000", "0000", "0000" }, { "0000", "0000", "0000", "0000", "0000", "0000" },
            { "0000", "0000", "0000", "0000", "0000", "0000" }, { "0000", "0000", "0000", "0000", "0000", "0000" },
            { "0000", "0000", "0000", "0000", "0000", "0000" }, { "0000", "0000", "0000", "0000", "0000", "0000" },
            { "0000", "0000", "0000", "0000", "0000", "0000" }, { "0000", "0000", "0000", "0000", "0000", "0000" },
            { "0000", "0000", "0000", "0000", "0000", "0000" }, { "0000", "0000", "0000", "0000", "0000", "0000" },
            { "0000", "0000", "0000", "0000", "0000", "0000" }, { "0000", "0000", "0000", "0000", "0000", "0000" },
            { "0000", "0000", "0000", "0000", "0000", "0000" }, { "0000", "0000", "0000", "0000", "0000", "0000" },
            { "0000", "0000", "0000", "0000", "0000", "0000" }, { "0000", "0000", "0000", "0000", "0000", "0000" },
            { "0000", "0000", "0000", "0000", "0000", "0000" }, { "0000", "0000", "0000", "0000", "0000", "0000" },
            { "0010", "0010", "0010", "0000", "0010", "0000" }, { "0101", "0101", "0000", "0000", "0000", "0000" },
            { "0101", "0111", "0101", "0111", "0101", "0000" }, { "0010", "0011", "0110", "0011", "0110", "0010" },
            { "0100", "0001", "0010", "0100", "0001", "0000" }, { "0010", "0101", "0011", "0101", "0111", "0000" },
            { "0110", "0100", "0000", "0000", "0000", "0000" }, { "0010", "0100", "0100", "0100", "0010", "0000" },
            { "0100", "0010", "0010", "0010", "0100", "0000" }, { "0101", "0010", "0111", "0010", "0101", "0000" },
            { "0000", "0010", "0111", "0010", "0000", "0000" }, { "0000", "0000", "0000", "0000", "0110", "0100" },
            { "0000", "0000", "0111", "0000", "0000", "0000" }, { "0000", "0000", "0000", "0000", "0010", "0000" },
            { "0001", "0001", "0010", "0100", "0100", "0000" }, { "0011", "0101", "0101", "0101", "0110", "0000" },
            { "0010", "0110", "0010", "0010", "0111", "0000" }, { "0110", "0001", "0010", "0100", "0111", "0000" },
            { "0110", "0001", "0010", "0001", "0110", "0000" }, { "0001", "0101", "0111", "0001", "0001", "0000" },
            { "0111", "0100", "0110", "0001", "0110", "0000" }, { "0010", "0100", "0110", "0101", "0010", "0000" },
            { "0111", "0001", "0011", "0010", "0010", "0000" }, { "0010", "0101", "0010", "0101", "0010", "0000" },
            { "0010", "0101", "0011", "0001", "0010", "0000" }, { "0000", "0000", "0010", "0000", "0010", "0000" },
            { "0000", "0000", "0010", "0000", "0110", "0100" }, { "0001", "0010", "0100", "0010", "0001", "0000" },
            { "0000", "0000", "0111", "0000", "0111", "0000" }, { "0100", "0010", "0001", "0010", "0100", "0000" },
            { "0110", "0001", "0010", "0000", "0010", "0000" }, { "0111", "0101", "0101", "0100", "0111", "0000" },
            { "0010", "0101", "0111", "0101", "0101", "0000" }, { "0110", "0101", "0110", "0101", "0110", "0000" },
            { "0011", "0100", "0100", "0100", "0011", "0000" }, { "0110", "0101", "0101", "0101", "0110", "0000" },
            { "0111", "0100", "0110", "0100", "0111", "0000" }, { "0111", "0100", "0110", "0100", "0100", "0000" },
            { "0011", "0100", "0101", "0101", "0011", "0000" }, { "0101", "0101", "0111", "0101", "0101", "0000" },
            { "0111", "0010", "0010", "0010", "0111", "0000" }, { "0001", "0001", "0001", "0101", "0010", "0000" },
            { "0101", "0101", "0110", "0101", "0101", "0000" }, { "0100", "0100", "0100", "0100", "0111", "0000" },
            { "0101", "0111", "0111", "0101", "0101", "0000" }, { "0101", "0111", "0101", "0101", "0101", "0000" },
            { "0010", "0101", "0101", "0101", "0010", "0000" }, { "0110", "0101", "0110", "0100", "0100", "0000" },
            { "0010", "0101", "0101", "0111", "0011", "0000" }, { "0110", "0101", "0110", "0101", "0101", "0000" },
            { "0011", "0100", "0111", "0001", "0110", "0000" }, { "0111", "0010", "0010", "0010", "0010", "0000" },
            { "0101", "0101", "0101", "0101", "0111", "0000" }, { "0101", "0101", "0101", "0101", "0010", "0000" },
            { "0101", "0101", "0111", "0111", "0101", "0000" }, { "0101", "0101", "0010", "0101", "0101", "0000" },
            { "0101", "0101", "0010", "0010", "0010", "0000" }, { "0111", "0001", "0010", "0100", "0111", "0000" },
            { "0110", "0100", "0100", "0100", "0110", "0000" }, { "0100", "0100", "0010", "0001", "0001", "0000" },
            { "0110", "0010", "0010", "0010", "0110", "0000" }, { "0010", "0101", "0000", "0000", "0000", "0000" },
            { "0000", "0000", "0000", "0000", "0000", "1111" }, { "0110", "0010", "0000", "0000", "0000", "0000" },
            { "0000", "0000", "0011", "0101", "0111", "0000" }, { "0100", "0100", "0110", "0101", "0110", "0000" },
            { "0000", "0000", "0011", "0100", "0011", "0000" }, { "0001", "0001", "0011", "0101", "0011", "0000" },
            { "0000", "0000", "0111", "0110", "0011", "0000" }, { "0001", "0010", "0111", "0010", "0010", "0000" },
            { "0000", "0000", "0111", "0101", "0001", "0111" }, { "0100", "0100", "0110", "0101", "0101", "0000" },
            { "0010", "0000", "0010", "0010", "0010", "0000" }, { "0010", "0000", "0010", "0010", "0010", "0110" },
            { "0100", "0100", "0101", "0110", "0101", "0000" }, { "0010", "0010", "0010", "0010", "0010", "0000" },
            { "0000", "0000", "0111", "0111", "0101", "0000" }, { "0000", "0000", "0110", "0101", "0101", "0000" },
            { "0000", "0000", "0010", "0101", "0010", "0000" }, { "0000", "0000", "0110", "0101", "0110", "0100" },
            { "0000", "0000", "0011", "0101", "0011", "0001" }, { "0000", "0000", "0110", "0100", "0100", "0000" },
            { "0000", "0000", "0011", "0010", "0110", "0000" }, { "0000", "0010", "0111", "0010", "0011", "0000" },
            { "0000", "0000", "0101", "0101", "0111", "0000" }, { "0000", "0000", "0101", "0101", "0010", "0000" },
            { "0000", "0000", "0101", "0111", "0111", "0000" }, { "0000", "0000", "0101", "0010", "0101", "0000" },
            { "0000", "0000", "0101", "0101", "0010", "0100" }, { "0000", "0000", "0110", "0010", "0011", "0000" },
            { "0011", "0010", "0110", "0010", "0011", "0000" }, { "0010", "0010", "0010", "0010", "0010", "0000" },
            { "0110", "0010", "0011", "0010", "0110", "0000" }, { "0101", "1010", "0000", "0000", "0000", "0000" },
            { "0000", "0010", "0101", "0111", "0000", "0000" } };

}