package knpraktyka.dnhbe.ai;

public class PromptTemplates {
    public static final String DOMAIN_PROMPT = """
        Company/website description: %s

        Generate %d short, brandable, domain name ideas 
        (just names without extensions) that are:
        - Available as domains (check technically)
        - Easy to remember
        - Relevant to the description
        - Maximum 2 words combined

        Return ONLY comma-separated values in this exact format:
        name1, name2, name3, ..., name%d
        """;
}
