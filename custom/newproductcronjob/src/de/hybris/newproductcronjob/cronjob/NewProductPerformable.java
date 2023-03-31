
package de.hybris.newproductcronjob.cronjob;
import de.hybris.myshoestore.core.dao.NewProductsDao;
import de.hybris.myshoestore.core.model.NewProductsModel;

import de.hybris.newproductcronjob.model.NewProductCronJobModel;
import org.apache.log4j.Logger;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.servicelayer.cronjob.PerformResult;

import java.util.ArrayList;
import java.util.List;


public class NewProductPerformable extends AbstractJobPerformable<NewProductCronJobModel>
{

	private NewProductsDao newProductsDao;
	private static final Logger LOG = Logger.getLogger(NewProductPerformable.class.getName());

	public void setNewProductsDao(NewProductsDao newProductsDao){
		this.newProductsDao=newProductsDao;
	}

	@Override
	public PerformResult perform(final NewProductCronJobModel cronJobModel)//try with passing NewProductsModel
	{
		LOG.info("**********************************");
		LOG.info("Hello World");
		LOG.info("**********************************");

		List<NewProductsModel> newList=newProductsDao.getNewProductsDetails();

		for (final NewProductsModel i:newList)
		{
			LOG.info(i.getCode());
			
		}

		LOG.info("**********************************");

		return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
	}
}