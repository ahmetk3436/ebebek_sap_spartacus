public class EbebekCaseJobPerformable extends AbstractJobPerformable<CronJobModel>
{
    private static final Logger log = Logger.getLogger(EbebekCaseJobPerformable.class);

    @Autowired
    EbebekCaseDao ebebekCaseDao;

    @Override
    public PerformResult perform(final CronJobModel cronJob)
    {
        final SearchResult<ProductModel> searchResult = ebebekCaseDao.getProducts();

        log.info(" Print data");
        searchResult.getProducts().stream().forEach(this::takeData);
        return new PerformResult(CronJobResult.SUCCESS,CronJobStatus.FINISHED);
    }

    void takeData()
    {
        List<ProductModel> lstProducts=ebebekCaseDao.getProducts();

        for(ProductModel product : lstProducts)
        {
            System.out.println("Product code: "+product.getCode()):
        }
    }

}