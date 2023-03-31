 package de.hybris.promotionenginetrail.conveters.populator;

 import de.hybris.platform.converters.Populator;
 import de.hybris.platform.customerreview.model.CustomerReviewModel;
 import de.hybris.platform.promotionenginetrail.rao.CustomerReviewRAO;
 import de.hybris.platform.servicelayer.dto.converter.ConversionException;
 public class CustomerReviewRaoPopulator implements Populator<CustomerReviewModel, CustomerReviewRAO>
 {

     @Override
     public void populate(CustomerReviewModel customerReviewModel, CustomerReviewRAO customerReviewRAO) throws ConversionException {
         customerReviewRAO.setProductCode(customerReviewModel.getProduct().getCode());
     }
 }