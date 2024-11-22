/**
 * Unit tests for parsing and constructing tangent expressions with the ExpressionTreeGenerator.
 * @author Nisha Walvekar
 * 
 */
class ExpressionTreeGeneratorTests {

    private ExpressionTreeGenerator parser;

    /**
     * Sets up the ExpressionTreeGenerator before each test.
     * 
     * @throws Exception if setup fails.
     */
    @BeforeEach
    void setUp() throws Exception {
        parser = new ExpressionTreeGenerator();
    }

    /**
     * Tests parsing and constructing ceiling expressions.
     */
    @Test
    public void ceilFunctionTests() {
        // Test for simple ceiling of x
        ExpressionTreeNode e = parser.makeExpression("Ceil(x)");
        assertEquals(new Ceil(new X()), e);

        // Test for ceiling of a complex expression: Ceil(x + y)
        e = parser.makeExpression("Ceil( x + y )");
        assertEquals(new Ceil(new Addition(new X(), new Y())), e);
    }
} 
