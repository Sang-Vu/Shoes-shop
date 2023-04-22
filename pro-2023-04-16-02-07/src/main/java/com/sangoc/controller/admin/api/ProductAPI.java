package com.sangoc.controller.admin.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sangoc.model.ProductModel;
import com.sangoc.model.ResponseObject;
import com.sangoc.service.IProductService;
import com.sangoc.ultils.HttpUltil;

@WebServlet(urlPatterns = { "/api-admin-product" })
public class ProductAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private IProductService productService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ResponseObject objectRespone = new ResponseObject();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ProductModel product = HttpUltil.of(req.getReader()).toModel(ProductModel.class);
		List<ProductModel> foundProduct = productService.findByCategoryId(product.getCategoryId(), 1);
		
		objectRespone.setStatus("Failed");
		objectRespone.setMessage("Not found product with categoryId = " + product.getCategoryId());
		objectRespone.setData("");
		if (!foundProduct.isEmpty()) {
			objectRespone.setStatus("OK");
			objectRespone.setMessage("Query proudct successfully");
			objectRespone.setData(foundProduct);
		}
		mapper.writeValue(resp.getOutputStream(), objectRespone);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ProductModel product = HttpUltil.of(req.getReader()).toModel(ProductModel.class);
		product = productService.save(product);
		mapper.writeValue(resp.getOutputStream(), product);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ProductModel product = HttpUltil.of(req.getReader()).toModel(ProductModel.class);
		product = productService.update(product);
		mapper.writeValue(resp.getOutputStream(), product);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ProductModel product = HttpUltil.of(req.getReader()).toModel(ProductModel.class);
		productService.delete(product.getIds());
		mapper.writeValue(resp.getOutputStream(), "{}");
	}
}
