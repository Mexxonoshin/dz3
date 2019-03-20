/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package artMeh;

import artMeh.dto.CustomSource;
import artMeh.dto.CustomURL;
import artMeh.models.Address;
import artMeh.models.Person;
import artMeh.services.PersonService;
import artMeh.services.impl.PersonServiceImpl;
import artMeh.utils.CheckUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static artMeh.utils.CheckUtils.checkSourceLists;
import static artMeh.utils.CheckUtils.checkUrlsOnNull;
import static artMeh.utils.FileUtils.readAllLinesOfFilesAsStrings;

public class App {

    private static final int COUNT = 30;

    private static final String FILE_NAMES_MALE = "NamesMale.txt";
    private static final String FILE_NAMES_FEMALE = "NamesFemale.txt";
    private static final String FILE_MIDDLE_NAMES_MALE = "MiddleNamesMale.txt";
    private static final String FILE_MIDDLE_NAMES_FEMALE = "MiddleNamesFemale.txt";
    private static final String FILE_LAST_NAMES_MALE = "LastNamesMale.txt";
    private static final String FILE_LAST_NAMES_FEMALE = "LastNamesFemale.txt";

    private static final String FILE_COUNTY = "Countries.txt";
    private static final String FILE_REGION = "Regions.txt";
    private static final String FILE_CITY = "Cities.txt";
    private static final String FILE_STREET = "Streets.txt";
    private static final String FILE_BUILDING = "Buildings.txt";
    private static final String FILE_APARTMENT = "Apartments.txt";

    public static void main(final String[] args){
        System.out.println(CheckUtils.checkInn("774523564587"));

        Class cls = App.class;
        final URL urlNamesMale = cls.getResource('/' + FILE_NAMES_MALE);
        final URL urlNamesFemale = cls.getResource('/' + FILE_NAMES_FEMALE);
        final URL urlMiddleNamesMale = cls.getResource('/' + FILE_MIDDLE_NAMES_MALE);
        final URL urlMiddleNamesFemale = cls.getResource('/' + FILE_MIDDLE_NAMES_FEMALE);
        final URL urlLastNamesMale = cls.getResource('/' + FILE_LAST_NAMES_MALE);
        final URL urlLastNamesFemale = cls.getResource('/' + FILE_LAST_NAMES_FEMALE);
        final URL urlCountry = cls.getResource('/' + FILE_COUNTY);
        final URL urlRegion = cls.getResource('/' + FILE_REGION);
        final URL urlCity = cls.getResource('/' + FILE_CITY);
        final URL urlStreet = cls.getResource('/' + FILE_STREET);
        final URL urlBuilding = cls.getResource('/' + FILE_BUILDING);
        final URL urlApartment = cls.getResource('/' + FILE_APARTMENT);

        if (!checkUrlsOnNull(
                Arrays.asList(
                        new CustomURL(urlNamesMale,FILE_NAMES_MALE),
                        new CustomURL(urlNamesFemale,FILE_NAMES_FEMALE),
                        new CustomURL(urlMiddleNamesMale,FILE_MIDDLE_NAMES_MALE),
                        new CustomURL(urlMiddleNamesFemale,FILE_MIDDLE_NAMES_FEMALE),
                        new CustomURL(urlLastNamesMale,FILE_LAST_NAMES_MALE),
                        new CustomURL(urlLastNamesFemale,FILE_LAST_NAMES_FEMALE),
                        new CustomURL(urlCountry,FILE_COUNTY),
                        new CustomURL(urlRegion,FILE_REGION),
                        new CustomURL(urlCity,FILE_CITY),
                        new CustomURL(urlStreet,FILE_STREET),
                        new CustomURL(urlBuilding,FILE_BUILDING),
                        new CustomURL(urlApartment,FILE_APARTMENT)
                )
            )
        ) {
            return;
        }

        String namesMaleFile = urlNamesMale.getFile();
        String namesFemaleFile = urlNamesFemale.getFile();
        String middleNamesMaleFile = urlMiddleNamesMale.getFile();
        String middleNamesFemaleFile = urlMiddleNamesFemale.getFile();
        String lastNamesMaleFile = urlLastNamesMale.getFile();
        String lastNamesFemaleFile = urlLastNamesFemale.getFile();
        String countryFile = urlCountry.getFile();
        String regionFile = urlRegion.getFile();
        String cityFile = urlCity.getFile();
        String streetFile = urlStreet.getFile();
        String buildingFile = urlBuilding.getFile();
        String apartmentFile = urlApartment.getFile();

        List<String> namesMale = readAllLinesOfFilesAsStrings(namesMaleFile);
        List<String> namesFemale = readAllLinesOfFilesAsStrings(namesFemaleFile);
        List<String> middleNamesMale = readAllLinesOfFilesAsStrings(middleNamesMaleFile);
        List<String> middleNamesFemale = readAllLinesOfFilesAsStrings(middleNamesFemaleFile);
        List<String> lastNamesMale = readAllLinesOfFilesAsStrings(lastNamesMaleFile);
        List<String> lastNamesFemale = readAllLinesOfFilesAsStrings(lastNamesFemaleFile);
        List<String> country = readAllLinesOfFilesAsStrings(countryFile);
        List<String> region = readAllLinesOfFilesAsStrings(regionFile);
        List<String> city = readAllLinesOfFilesAsStrings(cityFile);
        List<String> street = readAllLinesOfFilesAsStrings(streetFile);
        List<String> building = readAllLinesOfFilesAsStrings(buildingFile);
        List<String> apartment = readAllLinesOfFilesAsStrings(apartmentFile);

        List<CustomSource> sources = Arrays.asList(
                new CustomSource(namesMale, FILE_NAMES_MALE),
                new CustomSource(namesFemale, FILE_NAMES_FEMALE),
                new CustomSource(middleNamesMale, FILE_MIDDLE_NAMES_MALE),
                new CustomSource(middleNamesFemale, FILE_MIDDLE_NAMES_FEMALE),
                new CustomSource(lastNamesMale, FILE_LAST_NAMES_MALE),
                new CustomSource(lastNamesFemale, FILE_LAST_NAMES_FEMALE),
                new CustomSource(country, FILE_COUNTY),
                new CustomSource(region, FILE_REGION),
                new CustomSource(city, FILE_CITY),
                new CustomSource(street, FILE_STREET),
                new CustomSource(building, FILE_BUILDING),
                new CustomSource(apartment, FILE_APARTMENT)
                );
        if (!checkSourceLists(sources, COUNT)) {
            return;
        }

        final PersonService personService = new PersonServiceImpl();

        final List<Person> persons = personService.getPersons(sources, COUNT);

        //поиграться в консольке
/*
        for(Person person : persons){
            System.out.println("--------------------------------------------------------------");
            System.out.println("ФИО: "+ person.getLastName()+ " " + person.getName()+ " "+ person.getMiddleName());
            System.out.printf("Дата рождения, пол, возраст: %s, %s, %s\n",
                    person.getBirthday().toString("yyyy-mm-dd"), person.getGender(), person.getAge());
            System.out.printf("Адрес: %s, %s, %s, %s, %s, %s %s\n", person.getAddress().getPostCode(),
                    person.getAddress().getCountry(), person.getAddress().getRegion(), person.getAddress().getCity(),
                    person.getAddress().getStreet(), person.getAddress().getBuilding(), person.getAddress().getApartment());
            System.out.printf("ИНН: %s\n", person.getInn());
            System.out.println("--------------------------------------------------------------");
        }
*/
        final HSSFWorkbook workbook = new HSSFWorkbook();
        final HSSFSheet sheet = workbook.createSheet("Люди");
        int rowNum = 0;
        Cell cell;
        Row row;
        final HSSFCellStyle style = createStyle(workbook);
        row = sheet.createRow(rowNum);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Фамилия");
        cell.setCellStyle(style);

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Имя");
        cell.setCellStyle(style);

        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Отчетсво");
        cell.setCellStyle(style);

        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Дата рождения");
        cell.setCellStyle(style);

        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Возраст");
        cell.setCellStyle(style);

        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Пол");
        cell.setCellStyle(style);

        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("Адрес");
        cell.setCellStyle(style);

        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("ИНН");
        cell.setCellStyle(style);

        for (Person person : persons) {

            rowNum++;

            row = sheet.createRow(rowNum);

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(person.getLastName());

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(person.getName());

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(person.getMiddleName());

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(person.getBirthday().toString("yyyy-mm-dd"));

            cell = row.createCell(4, CellType.NUMERIC);
            cell.setCellValue(person.getAge());

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue(person.getGender());

            final Address address = person.getAddress();
            final String addressStr = address.getPostCode() + ", " +
                    address.getCountry() + ", " + address.getRegion() + ", " +
                    address.getCity() + ", " + address.getStreet() + ", " +
                    address.getBuilding() + ", " + address.getApartment();
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue(addressStr);

            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue(person.getInn());
        }

        try{
            File file = new File("people.xls");
            file.createNewFile();
            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            System.out.println("Created file: " + file.getAbsolutePath());
        }catch (Exception exp){
            System.err.println("Could not to create file!!!");
            exp.getStackTrace();
        }
    }

    private static HSSFCellStyle createStyle(final HSSFWorkbook wb){
        final HSSFFont font = wb.createFont();
        font.setBold(true);
        final HSSFCellStyle style = wb.createCellStyle();
        style.setFont(font);
        return style;
    }
}
