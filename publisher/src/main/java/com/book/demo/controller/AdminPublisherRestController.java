package com.book.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.demo.dto.MyDTO;
import com.book.demo.dto.PublisherDefaultResponseDTO;
import com.book.demo.entity.Publisher;
import com.book.demo.service.PublisherService;
import com.book.demo.util.PublisherDTOConvertor;

@RestController
@RequestMapping("/admin")
public class AdminPublisherRestController {
	@Autowired
	PublisherService publisherService;

	@Autowired
	PublisherDTOConvertor publisherDTOConvertor;

	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());

	//// localhost:8008/admin/addPublisher
	@PostMapping("/addPublisher")
	public ResponseEntity<MyDTO> addPublisher(@RequestBody Publisher publisher) throws Exception {

		System.out.println("\n\n--->> Inside controller HI  :- " + publisher);
		Publisher savedPublisher = publisherService.addPublisher(publisher);
		PublisherDefaultResponseDTO respDTO = PublisherDTOConvertor.convertToDTO(savedPublisher);
		return new ResponseEntity<MyDTO>(respDTO, HttpStatus.OK);

	}

	// localhost:8008/admin/allpublishers
	@GetMapping("/allpublishers")
	public List<Publisher> getAllPublisher() {
		try {
			List<Publisher> allExtractedPublishers = publisherService.getAllPublishers();
			return allExtractedPublishers;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// localhost:8008/admin/publisher/{publisherId}
	@PutMapping("/publisher/{publisherId}")
	public Publisher updatePublisher(@PathVariable int publisherId, @RequestBody Publisher publisherDetails)
			throws Exception {
		publisherService.getPublisherByPublisherId(publisherId);
		publisherDetails.setPublisherId(publisherId);
		Publisher updatePublisher = publisherService.addPublisher(publisherDetails);
		return updatePublisher;
	}

	// localhost:8008/admin/delete/{searchPublisherid}
	@DeleteMapping("/delete/{searchPublisherid}")
	public void deletePublisherById(@PathVariable int searchPublisherid) {

		try {
			publisherService.deletePublisherById(searchPublisherid);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// localhost:8008/admin/id/1
	@GetMapping("/id/{searchPublisherid}")
	public Publisher getPublisherByPublisherID(@PathVariable int searchPublisherid) throws Exception {
		return publisherService.getPublisherByPublisherId(searchPublisherid);
	}

	// localhost:8008/admin/publisherbyid?range1=1&range2=4
	@GetMapping("/publisherbyid")
	public List<Publisher> getPublisherSBetweenIds(@RequestParam int range1, @RequestParam int range2)
			throws Exception {

		return publisherService.getPublishersBetweenIds(range1, range2);
	}

	// localhost:8008/admin/filterpublishername/{publisherName}
	@GetMapping("/filterpublishername/{publisherName}")
	public List<Publisher> filterPublisher1(@PathVariable String publisherName) throws Exception {

		List<Publisher> allfiltered = publisherService.filterByPublisherName(publisherName);
		return allfiltered;
	}

	// localhost:8008/admin/filterAddress/{address}
	@GetMapping("/filteraddress/{address}")
	public List<Publisher> filterPublisher2(@PathVariable String address) throws Exception {

		List<Publisher> allfiltered = publisherService.filterByAddress(address);
		return allfiltered;
	}

	// localhost:8008/admin/filterCountry/{country}
	@GetMapping("/filtercountry/{country}")
	public List<Publisher> filterPublisher3(@PathVariable String country) throws Exception {

		List<Publisher> allfiltered = publisherService.filterByCountry(country);
		return allfiltered;
	}

	@GetMapping("/sort/{country}")
	public List<Publisher> getBySorting() throws Exception {
		List<Publisher> allSorted = publisherService.SortingPublishersBasedOnCountry();
		return allSorted;
	}
}
