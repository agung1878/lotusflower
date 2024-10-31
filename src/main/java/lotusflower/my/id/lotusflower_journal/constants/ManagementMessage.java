package lotusflower.my.id.lotusflower_journal.constants;

public class ManagementMessage {

    public static String deleteError(String entityName) {
        return "An error occurred while deleting " + entityName;
    }
    public static String deleteSuccess(String entityName) {
        return "The " + entityName + " was deleted";
    }

    public static String saveError(String entityName, String errorMessage) {
        return "Failed to save " + entityName + ", " + errorMessage;
    }
    public static String saveSuccess(String entityName) {
        return entityName + " data successfully saved";
    }
}
