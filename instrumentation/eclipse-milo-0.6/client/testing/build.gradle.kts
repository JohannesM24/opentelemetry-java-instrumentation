plugins {
  id("otel.java-conventions")
}

dependencies {
  // Dependency for Eclipse Milo
  implementation("org.eclipse.milo:sdk-client:0.6.5") // Replace with the Milo version you're using

  // Dependencies for Java agent testing
  api(project(":testing-common"))
  testImplementation("org.junit.jupiter:junit-jupiter:5.9.2") // JUnit 5 for writing tests

  // Additional dependencies for testing (optional)
  testImplementation("org.assertj:assertj-core:3.24.2") // Assertions
  testImplementation("org.mockito:mockito-core:5.5.0") // Mocking
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}
