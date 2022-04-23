Hey, this is a sample of UI tests with Selenium using TestNG annotations and JAVA.
The project was built using the page objects approach.

The tests are running on site: "https://atid.store"
project divided into three tests:
- perform a search: input data in the search field and check out the results containing the search criteria.
- add a product to the cart: navigates to MENs page,
  choosing a random item in the list, then checks out the cart value and product value and adds the product to the cart. If the cart value is updated with the price of the product the test will pass.
- fill out the contact us form: go to the contact us form, fill out the input fields then submits the form. If after submitting the form a message of approval is shown, the test passes.
