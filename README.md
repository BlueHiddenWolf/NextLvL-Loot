Online Game Shop Project (NextLvlLoot)

Introduction

NextLvlLoot is a comprehensive online platform where customers can purchase games, consoles and accessories. The platform caters to both admins and users, offering a variety of functionalities tailored to their needs.

Contents:
•	Analysis
•	Design
•	Implementation
•	Project Management

Analysis

Scenario
NextLvlLoot aims to replicate and enhance the traditional retail experience found in stores like GameStop, by providing an interactive and comprehensive online platform where customers can explore and purchase gaming-related products.

<img width="454" alt="image" src="https://github.com/BlueHiddenWolf/NextLvL-Loot/assets/161600523/de9403d3-63fd-4267-b653-201b37c20751">


User Stories
User View
1.	As a User, I want to view a comprehensive list of games, so I can choose my favorite games to purchase or explore.
2.	As a User, I want to view all available consoles, so I can decide which console best suits my gaming needs.
3.	As a User, I want to browse through available gaming accessories, enhancing my gaming experience with additional equipment.
4.	As a User, I want to see the current weekly special offer, so I can take advantage of discounts on bundles that include games and consoles.
5.	As a User, I want to add products to my shopping cart, so I can manage my purchases in one place before checking out.
Admin View
6.	As an Admin, I want to add, update, and delete games from our catalog, so that our game offerings are current and tailored to market demand.
7.	As an Admin, I want to manage our console inventory by adding, updating, and deleting product listings to keep our stock up-to-date and appealing to customers.
8.	As an Admin, I want to control our accessories inventory by adding new items, updating existing ones, and removing outdated products to maintain a competitive edge.
9.	As an Admin, I want the ability to manually set up and modify weekly special offers, ensuring they are attractive and correctly priced to boost sales.
10.	As an Admin, I want to use a responsive web application on various devices, ensuring I can manage the Gameshop inventory and sales from anywhere.
11.	As an Admin, I want a consistent user interface with easy navigation to efficiently manage inventory, offers, and sales without unnecessary complexity.
12.	As an Admin, I want to ensure secure login capabilities, so that management operations are protected against unauthorized access.

Use Cases

<img width="254" alt="image" src="https://github.com/BlueHiddenWolf/NextLvL-Loot/assets/161600523/55d9159b-e55e-41c0-8b16-bd61312cb852">


User View
-	UC-1 [View Games]: Users can browse through the entire catalog of games available in the Gameshop.
-	UC-2 [View Consoles]: Users can view all available consoles in the Gameshop.
-	UC-3 [View Accessories]: Users can browse through the selection of gaming accessories.
-	UC-4 [View Weekly Special Offer]: Users can view the current special offer, which automatically updates each week to include a discounted console and game bundle.
-	UC-5 [Add Product to Cart]: Users can add games, consoles, and accessories to their shopping cart for purchase.
Admin View
-	UC-6 [Manage Games]: Admins can add new games to the inventory, update existing game details, and delete games from the system.
-	UC-7 [Manage Consoles]: Admins can add new consoles, update existing console details, and delete consoles from the inventory.
-	UC-8 [Manage Accessories]: Admins can add, update, or remove accessories in the shop's inventory.
-	UC-9 [Create Weekly Special Offer Manually]: Admins can manually create or update the weekly special offer ahead of the automated schedule.



Design

Wireframe

The Wireframes we created in the beginning of the project was too ambitious for the scope of the project and the time we had to create it. In the future the website could look more similar to the wireframes but for that more time and resources are needed.
The Wireframes below show the Homepage view of the website as well as the checkout view where the User can see the products added to the cart and proceed to the payment.

<img width="231" alt="image" src="https://github.com/BlueHiddenWolf/NextLvL-Loot/assets/161600523/3b7d83f7-9906-41a5-b2ee-50f415ff7805">

<img width="263" alt="image" src="https://github.com/BlueHiddenWolf/NextLvL-Loot/assets/161600523/e15dd925-6f55-417d-a670-7778fce5c4a5">




Prototype Design

The platform is designed to ensure a seamless experience across various devices. It utilizes a consistent visual theme for easy navigation.
Domain Design
The domain encompasses entities like Games, Consoles, Accessories, each defined with comprehensive attributes. These entities are interrelated, supporting the structured data required for the underlying business logic.


Implementation

Backend Technology

The backend is developed on GitHub Codespaces using Spring Boot, integrated with Spring Data JPA for database interactions and H2 as the in-memory database to streamline development and testing phases.

Frontend Technology

The NextLvlLoot Gameshop is equipped with several key views on its frontend interface, each connected to specific backend APIs to fetch and manage data dynamically. Below is a description of each view and the corresponding APIs used:

Games View

The Games View is designed to present a comprehensive list of all games available in the shop. In this view, users can browse through an array of games, getting to see crucial details such as the title, genre, price, and availability. The data for the games is fetched from the API endpoint at https://verbose-happiness-wrv9rgpvxjgr25pxg-8080.app.github.dev/catalog/games. This endpoint provides a detailed list of games stored in the backend database, ensuring users have access to the latest game releases and stock availability.

Consoles View

In the Consoles View, all gaming consoles available for purchase are displayed. This view allows users to explore various console options, providing detailed information such as the model, manufacturer, price, and specifications. Consoles information is retrieved from https://verbose-happiness-wrv9rgpvxjgr25pxg-8080.app.github.dev/catalog/consoles, which helps keep the display updated with the current stock levels and the latest releases in the gaming console market.

Accessories View

The Accessories View showcases a wide range of gaming accessories like controllers, headsets, and more, enhancing the gaming setup for enthusiasts. Users can explore different accessories through this view, where each item is detailed to aid in their purchasing decisions. The data for accessories is sourced from https://verbose-happiness-wrv9rgpvxjgr25pxg-8080.app.github.dev/catalog/accesories, listing all available accessories comprehensively.

Login View

The Login View secures access to administrative functionalities, crucial for maintaining the integrity and management of the inventory and sales data. This view is not just for admins but also allows users to log in to view their orders and access personal offers. Authentication processes are managed through https://verbose-happiness-wrv9rgpvxjgr25pxg-8080.app.github.dev/login, interfacing directly with the security backend to validate user credentials effectively.

Discounts View

The Discounts View is tailored to feature special offers and discounts on games and consoles, appealing to both casual shoppers and avid gamers. Both users and admins can access this view to explore weekly special offers, which might include discounts on bundles or individual products. These special offers are dynamically displayed and updated from the API at https://verbose-happiness-wrv9rgpvxjgr25pxg-8080.app.github.dev/catalog/special-offers, ensuring the latest deals are always presented.


Developed using Budibase, the application can be accessed at https://inttech.budibase.app/app/nextlvloot.

Business Logic

A significant feature includes a dynamic special offer system where a console and game package is randomly selected each week and offered at a 10% discount. This system encourages regular customer engagement and sales uplift.
Path: [/api/catalog/special-offers]
Method: GET

Execution

The application is hosted in GitHub Codespaces, facilitating continuous development and deployment. The frontend connects to backend services deployed dynamically within Codespaces, providing a real-time development environment that reflects changes instantly across the platform.
This comprehensive setup ensures that NextLvlLoot remains a cutting-edge solution, perfectly aligning with the modern needs of an online gaming shop, while also providing robust management tools for the administrators.

Project Management

Roles
•	Back-end Developer: Sander Bessems. Frederik Cefalà, Taoufik Brinis.
•	Front-end Developer: Sander Bessems. Frederik Cefalà, Taoufik Brinis.
Milestones
•	Initiation: Set up project infrastructure using GitHub Codespaces and Budibase.
•	Development: Implementation of backend services and frontend interfaces.
•	Integration: Linking frontend with backend APIs, ensuring functional coherence.
•	Deployment and Testing: Final adjustments, deployment, and testing of the entire platform.
