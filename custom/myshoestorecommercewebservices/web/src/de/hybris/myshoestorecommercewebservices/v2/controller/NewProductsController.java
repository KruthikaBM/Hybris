package de.hybris.myshoestorecommercewebservices.v2.controller;

import de.hybris.myshoestore.facades.newproducts.impl.NewProductsFacadeImplApi;
import de.hybris.platform.commercefacades.product.data.NewProducts;
import de.hybris.platform.commercewebservicescommons.dto.NewProducts.NewProductsDataListWSDTO;
import de.hybris.platform.webservicescommons.swagger.ApiBaseSiteIdParam;
import de.hybris.platform.webservicescommons.swagger.ApiFieldsParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping(value="/myShoeStore/en")
@Api(tags="NewProducts")
public class NewProductsController extends BaseCommerceController{
    private static  final String Products_Mapping="code,name,description,size,color,purchaseDate,warranty";
    public  static final  String Product_Does_Not_Eixt="Product with given id:'%s' does not exist";
    private static final String OBJECT_NAME_PRODUCT_ID = "code";
    private static final Logger LOGGER= Logger.getLogger(NewProductsController.class);

    @Resource(name="newProductsFacadeApi")
    private NewProductsFacadeImplApi newProductsFacadeImplApi;

    public NewProductsFacadeImplApi getNewProductsFacadeImplApi() {
        return newProductsFacadeImplApi;
    }

    public void setNewProductsFacadeImplApi(NewProductsFacadeImplApi newProductsFacadeImplApi) {
        this.newProductsFacadeImplApi = newProductsFacadeImplApi;
    }

    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(nickname = "getSpecificProductDetails", value = "Get a Specific Product Details",
            notes = "Return a specific product based on code",
           authorizations = {@Authorization(value = "oauth2_client_credentials")})
    @ApiBaseSiteIdParam

    public NewProductsDataListWSDTO getSpecificProductDetails(@ApiParam(value="code", required=true)
                                                  @PathVariable final String code, @ApiParam(value="Response configuaration. This is the list of filelds that should be returned in the response body",allowableValues="BASIC,DEFAULT,FULL")
                                                    @RequestParam(defaultValue=DEFAULT_FIELD_SET) final String fields)
    {
        LOGGER.info("Product is "+code);
        final NewProductsDataListWSDTO newProductsList=new NewProductsDataListWSDTO();
        newProductsList.setNewProducts(getNewProductsFacadeImplApi().getSpecificProductDetailsApi(code));
        return getDataMapper().map(newProductsList,NewProductsDataListWSDTO.class,fields);
    }
    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(value = "/{code}", method = RequestMethod.DELETE)
    @ApiOperation(nickname = "removeProducts", value = "Delete Products",
            notes = "Removes Products",
            authorizations = {@Authorization(value = "oauth2_client_credentials")})
    @ApiBaseSiteIdParam
    @ResponseStatus(HttpStatus.OK)
    public void removeEmployee(@ApiParam(value = "code", required = true) @PathVariable final String code)
    {
        LOGGER.info("removeEmployee: id = " + code);
        getNewProductsFacadeImplApi().removeProduct(code);
    }

    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(value = "/allproducts", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(nickname = "getAllProductsDetails", value = "Get a data of All Products Details",
            notes = "Return a data of All Products",
            authorizations = {@Authorization(value = "oauth2_client_credentials")})
    public NewProductsDataListWSDTO getAllProductsDetails()
    {
        LOGGER.info("Product Data");
        final NewProductsDataListWSDTO productDataList = new NewProductsDataListWSDTO();
        productDataList.setNewProducts(getNewProductsFacadeImplApi().getAllProductsDetails());
        return getDataMapper().map(productDataList, NewProductsDataListWSDTO.class);
    }

    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(nickname = "createProducts", value = "Create a Products",
            notes = "Create a Products",
            authorizations = {@Authorization(value = "oauth2_client_credentials")})
    @ApiBaseSiteIdParam
    public NewProductsDataListWSDTO createProducts(
            @ApiParam(value = "Products object", required = true) @RequestBody final NewProductsDataListWSDTO products,
            @ApiFieldsParam @RequestParam(defaultValue = DEFAULT_FIELD_SET) final String fields)
    {
        final NewProducts newProducts = getDataMapper().map(products, NewProducts.class, Products_Mapping);
        getNewProductsFacadeImplApi().createProducts(newProducts);
        return getDataMapper().map(newProducts, NewProductsDataListWSDTO.class, fields);
    }

    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(value = "/{code}", method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(nickname = "replaceproducts", value = "Updates products details", notes = "Updates products details.",
            authorizations = {@Authorization(value = "oauth2_client_credentials")})
    @ApiBaseSiteIdParam
    public void replaceProducts(@ApiParam(value = "code", required = true) @PathVariable final String code,
                                @ApiParam(value = "products object.", required = true) @RequestBody final NewProductsDataListWSDTO products)
    {
        if (getNewProductsFacadeImplApi().getSpecificProductDetailsApi(code).isEmpty())
        {
            LOGGER.error("products Not Found");
        }
        else
        {
            final NewProducts productsData = getDataMapper().map(products, NewProducts.class, Products_Mapping);
            getNewProductsFacadeImplApi().replaceProducts(productsData, code);
        }
    }

    @Secured("ROLE_TRUSTED_CLIENT")
    @RequestMapping(value = "/{code}/{description}", method = RequestMethod.PATCH)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
   @ApiOperation(nickname = "UpdateProduct", value = "Updates product description", notes = "Updates product description.",
            authorizations = {@Authorization(value = "oauth2_client_credentials")})
    @ApiBaseSiteIdParam
    public void replaceEmployee(@ApiParam(value = "code.", required = true) @PathVariable final String code,
                                @ApiParam(value = "description.", required = true) @PathVariable final String description)
    {
        if (getNewProductsFacadeImplApi().getSpecificProductDetailsApi(code).isEmpty())
        {
            LOGGER.error("Product Not Found");
        }
        else
        {
            getNewProductsFacadeImplApi().updateDescription(code, description);
        }
    }




}
