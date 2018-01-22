
import edu.duke.FileResource;
import java.util.ArrayList;

public class CharactersInPlay 
{
    private ArrayList<String>character;
    private ArrayList<Integer>counts;

    public CharactersInPlay()
    {
        character = new ArrayList<>();
        counts = new ArrayList<>();
    }

    public static void main(String args[])
    {
        CharactersInPlay obj = new CharactersInPlay();
        obj.tester();
    }
    
    public void update(String person)
    {
        int index = character.indexOf(person);

        if(index != -1)
        {
            int value = counts.get(index);
            counts.set(index, value + 1);
        }

        else
        {
            character.add(person);
            counts.add(1);
        }
    }

    public void findAllCharacters()
    {
        FileResource file = new FileResource();

        for(String string : file.lines())
        {
            int index = string.indexOf('.');

            if(index > -1)
            {
                int indexOfBlank = 0;
                while(indexOfBlank < index)
                {
                    if(string.charAt(indexOfBlank) == ' ')
                        indexOfBlank++;
                    else
                        break;
                }

                String person = string.substring(indexOfBlank, index);
                update(person);
            }
        }
    }

    public void characterWithNumParts(int num1, int num2)
    {
        for(int i=0; i<character.size(); i++)
        {
            if(counts.get(i) >= num1 && counts.get(i) <= num2)
                System.out.println(character.get(i) + ": " + counts.get(i));
        }
    }

    private void tester()
    {
        findAllCharacters();
        characterWithNumParts(2, 3);
    }
}