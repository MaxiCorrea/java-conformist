# Conformist | DDD Strategic Pattern Example

[![Pattern](https://img.youtube.com/vi/ZYMEdX5Xnxc/0.jpg)](https://www.youtube.com/watch?v=ZYMEdX5Xnxc)

## What is the Conformist Pattern?

In Domain-Driven Design, the **Conformist** pattern is a strategic relationship between two bounded contexts where the **downstream** team decides to conform entirely to the model of the **upstream** team, without attempting to translate or adapt it.

This pattern typically emerges when:

- The upstream team has no motivation (or capacity) to accommodate the needs of the downstream team.
- The downstream team does not have enough resources or justification to build an **Anti-Corruption Layer (ACL)**.
- The upstream model is sufficiently close to what the downstream needs, making translation unnecessary or not cost-effective.

In this scenario, the downstream context **adopts the upstream's model as its own**, accepting its language, its structures, and its constraints. The downstream team loses some autonomy in its design, but gains simplicity in integration and reduces the maintenance cost of a translation layer.

### Trade-offs

| Benefit | Cost |
|---|---|
| Simple and fast integration | Coupling to the upstream model |
| No translation layer to maintain | Loss of modeling autonomy in the downstream context |
| Aligned language across contexts | Changes in the upstream can propagate and break the downstream |

### When NOT to use it

If the upstream model is poorly designed, unstable, or fundamentally different from the downstream's domain needs, conforming to it can introduce **accidental complexity**. In those cases, an **Anti-Corruption Layer** or even a **Separate Ways** approach is preferable.

### Relationship with other patterns

- **Anti-Corruption Layer (ACL)**: The opposite decision — the downstream builds a translation layer to protect its own model from the upstream.
- **Shared Kernel**: Both teams collaborate on a shared subset of the model. Requires coordination that Conformist does not.
- **Customer-Supplier**: The upstream team actively considers the downstream's needs. In Conformist, this negotiation does not exist.

## About this example

This project illustrates the Conformist pattern with two bounded contexts:

- **Billing** (upstream): Exposes `BillingService` and `InvoiceDTO`, defining the invoice model with fields like `statusCode`, `currencyCode`, and `totalAmount`.
- **Risk** (downstream / conformist): The `FraudEvaluationService` and `FraudPolicy` consume `InvoiceDTO` directly, adapting to the upstream's representation (e.g., interpreting `"02"` as pending status) without introducing any translation layer.

The downstream context conforms to the upstream's model, accepting its naming conventions, its data types, and its encoding decisions (like using string codes for status). This is the defining characteristic of the Conformist pattern — the downstream **chooses not to fight** the upstream model.
